package com.conimmuty.repository;

import com.conimmuty.domain.CommentEntity;
import com.conimmuty.domain.PostEntity;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    @DisplayName(value = "댓글 작성")
    void save(){
        PostEntity post = new PostEntity("title", "content");
        PostEntity savedPost = postRepository.save(post);
        Long pid = savedPost.getPid();

        CommentEntity comment = new CommentEntity(pid, "comment1");
        CommentEntity savedComment = commentRepository.save(comment);
        assertThat(comment.getPid()).isEqualTo(savedComment.getPid());
        assertThat(comment.getCid()).isEqualTo(savedComment.getCid());
        assertThat(savedPost.getCommentCnt()).isEqualTo(1);

        commentRepository.save(comment);
        assertThat(savedPost.getCommentCnt()).isEqualTo(2);
    }

    @Test
    @DisplayName(value="모든 댓글 찾기")
    void findAll(){
        PostEntity post1 = new PostEntity("title1", "content1");
        PostEntity savedPost1 = postRepository.save(post1);
        Long pid1 = savedPost1.getPid();
        PostEntity post2 = new PostEntity("title2", "content2");
        PostEntity savedPost2 = postRepository.save(post2);
        Long pid2 = savedPost2.getPid();

        CommentEntity comment1 = new CommentEntity(pid1, "comment1");
        CommentEntity comment2 = new CommentEntity(pid2, "comment2");
        CommentEntity comment3 = new CommentEntity(pid1, "comment3");
        CommentEntity comment4 = new CommentEntity(pid2, "comment4");
        CommentEntity comment5 = new CommentEntity(pid1, "comment5");

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        commentRepository.save(comment5);
        List<CommentEntity> result1 = commentRepository.findAll(pid1);
        List<CommentEntity> result2 = commentRepository.findAll(pid2);
        assertThat(result1).containsExactly(comment1, comment3, comment5);
        assertThat(result2).containsExactly(comment2, comment4);
    }

    @Test
    @DisplayName(value = "특정 댓글 찾기")
    void findOne(){
        PostEntity post1 = new PostEntity("title1", "content1");
        PostEntity savedPost1 = postRepository.save(post1);
        Long pid1 = savedPost1.getPid();

        CommentEntity comment1 = new CommentEntity(pid1, "comment1");
        CommentEntity comment2 = new CommentEntity(pid1, "comment2");
        CommentEntity comment3 = new CommentEntity(pid1, "comment3");

        CommentEntity savedComment1 = commentRepository.save(comment1);
        CommentEntity savedComment2 = commentRepository.save(comment2);
        CommentEntity savedComment3 = commentRepository.save(comment3);

        Long cid1 = savedComment1.getCid();
        Long cid2 = savedComment2.getCid();
        Long cid3 = savedComment3.getCid();

        assertThatThrownBy(()->commentRepository.findOne(-1L, cid1)).isInstanceOf(NoSuchElementException.class);
        CommentEntity findComment1 = commentRepository.findOne(pid1, cid1);
        CommentEntity findComment2 = commentRepository.findOne(pid1, cid2);
        CommentEntity findComment3 = commentRepository.findOne(pid1, cid3);

        assertThat(findComment1).isEqualTo(savedComment1);
        assertThat(findComment2).isEqualTo(savedComment2);
        assertThat(findComment3).isEqualTo(savedComment3);
    }



}