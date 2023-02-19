package com.conimmuty.service;

import com.conimmuty.controller.dto.PostResponseDTO;
import com.conimmuty.domain.PostEntity;
import com.conimmuty.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void saveOne(String title, String content) {
        PostEntity post = new PostEntity(title, content);
        postRepository.save(post);
    }

    public PostResponseDTO findById(Long pid) {
        PostEntity postEntity = postRepository.findById(pid);
        return entity2DTO(postEntity);
    }

    public List<PostResponseDTO> findAll() {
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream().map(this::entity2DTO).toList();
    }

    public void doLike(Long pid) {
        postRepository.doLike(pid);
    }

    public void doDislike(Long pid) {
        postRepository.doDislike(pid);
    }

    private PostResponseDTO entity2DTO(PostEntity post) {
        Long pid = post.getPid();
        String content = post.getContent();
        String title = post.getTitle();
        Integer commentCnt = post.getCommentCnt();
        LocalDateTime createdAt = post.getCreatedAt();
        Integer dislikeCnt = post.getDislikeCnt();
        Integer likeCnt = post.getLikeCnt();
        return new PostResponseDTO(pid, title, content, likeCnt, dislikeCnt, commentCnt, createdAt);
    }
}
