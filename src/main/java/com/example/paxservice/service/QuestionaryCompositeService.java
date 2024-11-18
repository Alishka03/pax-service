package com.example.paxservice.service;

import com.example.paxservice.entity.QuestionaryCompositeEntity;
import com.example.paxservice.entity.embeddable.QuestionaryId;
import com.example.paxservice.repository.QuestionaryCompositeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionaryCompositeService {
    private final QuestionaryCompositeRepository repository;

    public QuestionaryCompositeService(QuestionaryCompositeRepository repository) {
        this.repository = repository;
    }

    public Optional<QuestionaryCompositeEntity> findOne(QuestionaryId id) {
        return repository.findById(id);
    }


}
