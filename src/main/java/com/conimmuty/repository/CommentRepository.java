package com.conimmuty.repository;

import com.conimmuty.domain.CommentEntity;
import com.conimmuty.repository.dao.JpaCommentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class CommentRepository {

    private final JpaCommentDao jpaCommentDao;
    private final PostRepository postRepository;

    public CommentEntity save(CommentEntity comment) {
        Long pid = comment.getPid();
        postRepository.doComment(pid);
        return jpaCommentDao.save(comment);
    }

    public List<CommentEntity> findAll(Long pid) {
        return jpaCommentDao.findAll(pid);
    }

    public CommentEntity findOne(Long pid, Long cid) {
        return jpaCommentDao.findOne(pid, cid).orElseThrow();
    }
}
