package com.conimmuty.repository;

import com.conimmuty.domain.PostEntity;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@Slf4j
@Transactional
@SpringBootTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    @DisplayName(value = "글 하나 저장")
    void save() {
        PostEntity post1 = new PostEntity("title1", "content1");
        PostEntity post2 = new PostEntity("title2", "content2");

        PostEntity savedPost1 = postRepository.save(post1);
        PostEntity savedPost2 = postRepository.save(post2);

        assertThat(savedPost1.getPid()).isEqualTo(post1.getPid());
        assertThat(savedPost2.getPid()).isEqualTo(post2.getPid());
    }

    @Test
    @DisplayName(value = "글 전체 불러오기")
    void getAll() {
        PostEntity post1 = new PostEntity("title1", "content1");
        PostEntity post2 = new PostEntity("title2", "content2");

        postRepository.save(post1);
        postRepository.save(post2);

        List<PostEntity> result = postRepository.findAll();
        assertThat(result).containsExactly(post1, post2);
    }

    @Test
    @DisplayName(value = "좋아요")
    void doLike() {
        PostEntity post = new PostEntity("title", "content");

        assertThat(post.getLikeCnt()).isEqualTo(0);

        PostEntity savedPost = postRepository.save(post);
        Long pid = savedPost.getPid();

        postRepository.doLike(pid);

        assertThat(post.getLikeCnt()).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "싫어요")
    void doDislike() {
        PostEntity post = new PostEntity("title", "content");

        assertThat(post.getDislikeCnt()).isEqualTo(0);

        PostEntity savedPost = postRepository.save(post);
        Long pid = savedPost.getPid();

        postRepository.doDislike(pid);

        assertThat(post.getDislikeCnt()).isEqualTo(1);
    }


}