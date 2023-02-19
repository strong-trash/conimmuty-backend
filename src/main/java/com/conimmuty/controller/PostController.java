package com.conimmuty.controller;

import com.conimmuty.controller.dto.PostRequestDTO;
import com.conimmuty.controller.dto.PostResponseDTO;
import com.conimmuty.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post")
    public ResponseEntity<List<PostResponseDTO>> getAll() {
        List<PostResponseDTO> result = postService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/post/{pid}")
    public ResponseEntity<PostResponseDTO> getOne(@PathVariable("pid") Long pid) {
        PostResponseDTO post = postService.findById(pid);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Void> save(PostRequestDTO req) {
        String title = req.getTitle();
        String content = req.getContent();
        postService.saveOne(title, content);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/like/{pid}")
    public ResponseEntity<Void> like(@PathVariable("pid") Long pid) {
        postService.doLike(pid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/dislike/{pid}")
    public ResponseEntity<Void> dislike(@PathVariable("pid") Long pid) {
        postService.doDislike(pid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
