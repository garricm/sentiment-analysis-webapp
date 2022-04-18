package com.cloud.sentiment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.sentiment.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	Optional<Topic> findByTitle(String title);

}
