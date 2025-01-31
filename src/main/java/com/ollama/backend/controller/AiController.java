package com.ollama.backend.controller;


import com.ollama.backend.service.ai_service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    private ai_service Ai_service;

    public AiController(ai_service Ai_service) {
        this.Ai_service = Ai_service;
    }

    @GetMapping
    public ResponseEntity<String> askAI(
            @RequestParam(value = "query", required = false, defaultValue = "how are you? how can you help me?") String query

    ){
        String response = Ai_service.askAI(query);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/stream")
    public Flux<String> streamAi(
            @RequestParam(value = "query", required = false, defaultValue = "how are you? how can you help me?") String query

    ){

        return Ai_service.streamai(query);
    }
}
