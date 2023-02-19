package com.conimmuty.repository;

import com.conimmuty.domain.PostEntity;
import com.conimmuty.repository.dao.JpaPostDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class PostRepository {
    private final JpaPostDao jpaPostDao;

    public PostEntity save(PostEntity post) {
        jpaPostDao.save(post);
        return post;
    }

    public PostEntity findById(Long pid) {
        return jpaPostDao.findById(pid).orElseThrow();
    }

    public void doComment(Long pid) {
        PostEntity post = findById(pid);
        Integer commentCnt = post.getCommentCnt();
        post.setCommentCnt(commentCnt + 1);
    }

    public void doLike(Long pid) {
        PostEntity post = findById(pid);
        Integer likeCnt = post.getLikeCnt();
        post.setLikeCnt(likeCnt + 1);
    }

    public void doDislike(Long pid) {
        PostEntity post = findById(pid);
        Integer dislikeCnt = post.getDislikeCnt();
        post.setDislikeCnt(dislikeCnt + 1);
    }

    public List<PostEntity> findAll() {
        return jpaPostDao.findAll();
    }
}
