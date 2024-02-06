package com.example.demo.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ElasticsearchRepository<Task, String> {
}
