package com.conimmuty.repository.dao;

import com.conimmuty.domain.PostEntity;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostDao extends JpaRepository<PostEntity, Long> {
}
