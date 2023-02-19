package com.conimmuty.repository.dao;

import com.conimmuty.domain.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JpaCommentDao extends JpaRepository<CommentEntity, Long> {
    @Query(value = "select comment from CommentEntity comment where comment.pid = :pid")
    List<CommentEntity> findAll(final Long pid);

    @Query(value = "select comment from CommentEntity comment where comment.pid = :pid and comment.cid = :cid")
    Optional<CommentEntity> findOne(final Long pid, final Long cid);
}
