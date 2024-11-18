package com.example.paxservice.service;

import com.example.paxservice.Converter;
import com.example.paxservice.dto.PaxDataDTO;
import com.example.paxservice.dto.QuestionaryDTO;
import com.example.paxservice.dto.TerminalsInfoDTO;
import com.example.paxservice.entity.PaxDataEntity;
import com.example.paxservice.entity.QuestionaryCompositeEntity;
import com.example.paxservice.entity.QuestionaryEntity;
import com.example.paxservice.entity.TerminalsInfoEntity;
import com.example.paxservice.entity.embeddable.QuestionaryId;
import com.example.paxservice.repository.PaxDataRepository;
import com.example.paxservice.repository.QuestionaryCompositeRepository;
import com.example.paxservice.repository.QuestionaryRepository;
import com.example.paxservice.repository.TerminalsInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PaxDataServiceImpl implements PaxDataService {

    private final PaxDataRepository dataRepository;
    private final GoSignService goSignService;
    private final TerminalsInfoRepository terminalsInfoRepository;
    private final QuestionaryRepository questionaryRepository;
    private final QuestionaryCompositeRepository questionaryCompositeRepository;


    @Override
    public void savePaxDataRows(int page) {
        List<PaxDataDTO> dataFromApi = goSignService.getDataFromApi(page);
        for (PaxDataDTO paxDataDTO : dataFromApi) {
            PaxDataEntity entity = Converter.convertFromPaxDataDto(paxDataDTO);
            saveWithoutDuplicates(entity);
        }
        log.info("Saved in the table");
    }

    @Override
    public void saveAdditionalInfoRows(int page) {
        List<TerminalsInfoDTO> dtoList = goSignService.getAdditionalInfo(page);
        for (TerminalsInfoDTO dto : dtoList) {
            TerminalsInfoEntity entity = Converter.convertAdditionalInfoDtoToEntity(dto);
            saveAdditionalInfoWithoutDuplicates(entity);
        }
        log.info("Saved additional info");
    }

    @Override
    public void saveQuestionaryData(int page) {
        List<QuestionaryDTO> questionaryList = goSignService.getQuestionaryInfo(page);
        for (QuestionaryDTO questionary : questionaryList) {
            QuestionaryEntity entity = Converter.convertQuestionaryDtoToEntity(questionary);
            saveQuestionaryDataWithoutDuplicates(entity);
        }
        log.info("Saved questionary data");
        saveQuestionaryCompositeEntity(questionaryList);
    }

    @Override
    public void saveQuestionaryCompositeEntity(List<QuestionaryDTO> list) {
        log.info("Trying to save Questionary Composite Table");
        list.forEach(questionaryDTO -> {
            QuestionaryId id = new QuestionaryId(questionaryDTO.getSysTerminalId(), questionaryDTO.getPosId());
            Optional<QuestionaryCompositeEntity> entityOptional = questionaryCompositeRepository.findById(id);

            if (entityOptional.isEmpty()) {
                questionaryCompositeRepository.save(new QuestionaryCompositeEntity(id, questionaryDTO.getEventTime()));
            } else {
                QuestionaryCompositeEntity entity = entityOptional.get();
                ZonedDateTime dtoEventTimeInUtc = questionaryDTO.getEventTime().withZoneSameInstant(ZoneOffset.UTC);

                if (!dtoEventTimeInUtc.isEqual(entity.getEventTime())) {
                    entity.setEventTime(dtoEventTimeInUtc);
                    questionaryCompositeRepository.save(entity);
                    log.info("Updated event time for QuestionaryCompositeEntity with ID: {}", id);
                }
            }
        });
        log.info("Saved questionary values.");
    }


    public void saveWithoutDuplicates(PaxDataEntity paxDataEntity) {
        Optional<PaxDataEntity> existingEntity = findFirstByTerminalIdAndEventTime(paxDataEntity);
        if (existingEntity.isEmpty()) {
            dataRepository.save(paxDataEntity);
        }
    }

    public Optional<PaxDataEntity> findFirstByTerminalIdAndEventTime(PaxDataEntity newEntity) {
        return dataRepository.getFirst(newEntity.get_sys_terminalid(), newEntity.get_eventtime());
    }

    public Optional<TerminalsInfoEntity> getFirstByTerminalIdAndEvenTime(TerminalsInfoEntity entity) {
        return terminalsInfoRepository.getFirst(entity.getSysTerminalId(), entity.getEventTime());
    }

    public Optional<QuestionaryEntity> getFirstQuestionaryByTerminalIdAndEventTime(QuestionaryEntity entity) {
        return questionaryRepository.getFirst(entity.getSysTerminalId(), entity.getEventTime());
    }

    public void saveAdditionalInfoWithoutDuplicates(TerminalsInfoEntity entity) {
        Optional<TerminalsInfoEntity> existingEntity = getFirstByTerminalIdAndEvenTime(entity);
        if (existingEntity.isEmpty()) {
            terminalsInfoRepository.save(entity);
        }
    }

    public void saveQuestionaryDataWithoutDuplicates(QuestionaryEntity entity) {
        Optional<QuestionaryEntity> questionaryEntity = getFirstQuestionaryByTerminalIdAndEventTime(entity);
        if (questionaryEntity.isEmpty()) {
            questionaryRepository.save(entity);
        }
    }

}
