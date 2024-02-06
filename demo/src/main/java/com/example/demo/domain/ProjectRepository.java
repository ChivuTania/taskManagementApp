package com.example.demo.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends ElasticsearchRepository<Project, String> {
    Project findByName(String name);
}
