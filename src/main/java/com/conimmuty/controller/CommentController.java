package com.conimmuty.controller;

import com.conimmuty.controller.dto.CommentRequestDTO;
import com.conimmuty.controller.dto.CommentResponseDTO;
import com.conimmuty.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/{pid}")
    public ResponseEntity<List<CommentResponseDTO>> getAll(@PathVariable("pid") Long pid) {
        List<CommentResponseDTO> result = commentService.findAll(pid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/comment/{pid}/{cid}")
    public ResponseEntity<CommentResponseDTO> getOne(@PathVariable("pid") Long pid, @PathVariable("cid") Long cid) {
        CommentResponseDTO result = commentService.findOne(pid, cid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<Void> save(@RequestBody CommentRequestDTO req) {
        Long pid = req.getPid();
        String body = req.getBody();
        commentService.save(pid, body);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
