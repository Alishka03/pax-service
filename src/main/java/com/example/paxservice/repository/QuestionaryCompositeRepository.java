package com.example.paxservice.repository;

import com.example.paxservice.entity.QuestionaryCompositeEntity;
import com.example.paxservice.entity.embeddable.QuestionaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionaryCompositeRepository extends JpaRepository<QuestionaryCompositeEntity, QuestionaryId> {
}
