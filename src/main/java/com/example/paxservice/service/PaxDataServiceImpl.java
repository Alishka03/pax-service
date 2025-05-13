package com.example.paxservice.service;

import com.example.paxservice.Converter;
import com.example.paxservice.dto.*;
import com.example.paxservice.entity.*;
import com.example.paxservice.entity.embeddable.QuestionaryId;
import com.example.paxservice.repository.*;
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
    private final CashierModeRepository cashierModeRepository;
    private final SecurityInfoRepository securityInfoRepository;


    @Override
    public void savePaxDataRows(int page) {
        List<PaxDataDTO> dataFromApi = goSignService.getDataFromApi(page);
        if (!dataFromApi.isEmpty()) {
            for (PaxDataDTO paxDataDTO : dataFromApi) {
                PaxDataEntity entity = Converter.convertFromPaxDataDto(paxDataDTO);
                saveWithoutDuplicates(entity);
            }
            log.info("Saved in the table");
        }
    }

    @Override
    public void saveAdditionalInfoRows(int page) {
        List<TerminalsInfoDTO> dtoList = goSignService.getAdditionalInfo(page);
        if (!dtoList.isEmpty()) {
            for (TerminalsInfoDTO dto : dtoList) {
                TerminalsInfoEntity entity = Converter.convertAdditionalInfoDtoToEntity(dto);
                saveAdditionalInfoWithoutDuplicates(entity);
            }
            log.info("Saved additional info");
        }
    }

    @Override
    public boolean saveQuestionaryData(int page) {
        List<QuestionaryDTO> questionaryList = goSignService.getQuestionaryInfo(page);
        log.info("The length of questionary from GoInsight: " + questionaryList.size());
        int counter = 0;
        if (!questionaryList.isEmpty()) {
            for (QuestionaryDTO questionary : questionaryList) {
                QuestionaryEntity entity = Converter.convertQuestionaryDtoToEntity(questionary);
                boolean isSaved = saveQuestionaryEntity(entity);
                if (isSaved) {
                    log.info("Saved questionary : _eventtime: {}, posid: {}", entity.getEventTime(), entity.getPosId());
                    counter++;
                }
            }
            log.info("Saved Questionary data . Page : {} ,Size: {}", page, counter);
            saveQuestionaryCompositeEntity(questionaryList);
            return true;
        } else return false;
    }


    @Override
    public boolean saveQuestionaryList(List<QuestionaryDTO> questionaryList) {
        log.info("The length of questionary from GoInsight: " + questionaryList.size());
        int counter = 0;
        if (!questionaryList.isEmpty()) {
            for (QuestionaryDTO questionary : questionaryList) {
                QuestionaryEntity entity = Converter.convertQuestionaryDtoToEntity(questionary);
                boolean isSaved = saveQuestionaryEntity(entity);
                if (isSaved) {
                    log.info("Saved questionary : _eventtime: {}, posid: {}", entity.getEventTime(), entity.getPosId());
                    counter++;
                }
            }
            log.info("Saved Questionary data . ,Size: {}", counter);
            saveQuestionaryCompositeEntity(questionaryList);
            return true;
        } else return false;
    }


    @Override
    @Transactional
    public void saveQuestionaryCompositeEntity(List<QuestionaryDTO> list) {
        list.forEach(questionaryDTO -> {
            QuestionaryId id = new QuestionaryId(questionaryDTO.getSysTerminalId(), questionaryDTO.getPosId());
            Optional<QuestionaryCompositeEntity> entityOptional = questionaryCompositeRepository.findById(id);

            if (entityOptional.isEmpty()) {
                if (questionaryDTO.getPosId() != null) {
                    questionaryCompositeRepository.save(new QuestionaryCompositeEntity(id, questionaryDTO.getEventTime()));
                }
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


    public boolean saveCashierMode(int page) {
        List<CashierModeDTO> list = goSignService.getCashierModeInfo(page);

        if (list == null || list.isEmpty()) {
            log.info("No CashierMode data found to save. Page: {}", page);
            return false;
        }

        int counter = 0;
        for (CashierModeDTO cashierModeDTO : list) {
            CashierMode entity = Converter.convertCashierModeDtoToEntity(cashierModeDTO);
            boolean exists = cashierModeExistsBySysterminalIdAndEventTime(entity);

            if (!exists) {
                cashierModeRepository.save(entity);
                log.info("Saved CashierMode. SysTerminalId: {}, EventTime: {}", entity.getSysTerminalId(), entity.getEventTime());
                counter++;
            }
        }

        log.info("Saved {} CashierMode records. Page: {}", counter, page);
        return true;
    }

    @Transactional
    public boolean saveSecurityInfo(int page) {
        List<SecurityInfoDTO> list = goSignService.getSecurityInfoByPage(page);

        if (list == null || list.isEmpty()) {
            log.info("No SecurityInfo data found to save. Page: {}", page);
            return false;
        }

        int counter = 0;
        for (SecurityInfoDTO dto : list) {
            SecurityInfo entity = Converter.convertFromSecurityInfoDto(dto);
            boolean exists = securityInfoRepository.findBySysTerminalIdAndEventTime(entity.getSysTerminalId(), entity.getEventTime()).isPresent();

            if (!exists) {
                securityInfoRepository.save(entity);
                log.info("Saved SecurityInfo. SysTerminalId: {}, EventTime: {}", entity.getSysTerminalId(), entity.getEventTime());
                counter++;
            }
        }

        log.info("Saved {} SecurityInfo records. Page: {}", counter, page);
        return true;
    }


    public boolean cashierModeExistsBySysterminalIdAndEventTime(CashierMode entity) {
        Optional<CashierMode> exists = cashierModeRepository.findBySysTerminalIdAndEventTime(entity.getSysTerminalId(), entity.getEventTime());
        return exists.isPresent();
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

    private boolean saveQuestionaryEntity(QuestionaryEntity entity) {
        Optional<QuestionaryEntity> questionaryEntity = getFirstQuestionaryByTerminalIdAndEventTime(entity);
        if (questionaryEntity.isPresent()) {
            return false;
        } else {
            questionaryRepository.save(entity);
            return true;
        }
    }

}
