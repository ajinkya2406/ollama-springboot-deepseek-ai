package com.ollama.backend.service;

import reactor.core.publisher.Flux;

public interface ai_service {

    String askAI(String question);

    Flux<String> streamai(String question);

}
