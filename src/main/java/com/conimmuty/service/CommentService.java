package com.conimmuty.service;

import com.conimmuty.controller.dto.CommentResponseDTO;
import com.conimmuty.controller.dto.PostResponseDTO;
import com.conimmuty.domain.CommentEntity;
import com.conimmuty.domain.PostEntity;
import com.conimmuty.repository.CommentRepository;
import com.conimmuty.support.Utility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(Long pid, String body) {
        body = Utility.shuffle(body);
        CommentEntity comment = new CommentEntity(pid, body);
        commentRepository.save(comment);
    }

    public List<CommentResponseDTO> findAll(Long pid) {
        List<CommentEntity> result = commentRepository.findAll(pid);
        return result.stream().map(this::entity2DTO).toList();
    }

    public CommentResponseDTO findOne(Long pid, Long cid) {
        CommentEntity comment = commentRepository.findOne(pid, cid);
        return entity2DTO(comment);
    }

    private CommentResponseDTO entity2DTO(CommentEntity comment) {
        Long cid = comment.getCid();
        Long pid = comment.getPid();
        String body = comment.getBody();
        LocalDateTime createdAt = comment.getCreatedAt();

        return new CommentResponseDTO(cid, pid, body, createdAt);
    }
}
