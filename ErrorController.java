package com.spring.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class ErrorController {


    @Autowired
    public ErrorService service;

    @PostMapping("/error")
    public Mono<Error> createError(@Validated @RequestBody Error err) {
        return service.create(err);
    }

    @GetMapping(value="/errors", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Error> getAllErrors() {
        return (Flux<Error>) service.getAll().delayElements(Duration.ofSeconds(2));
    }

    @GetMapping("/error/{id}")
    public Mono<Error> getError(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/error/{id}")
    public Mono<Error> updateError(@PathVariable String id, @Validated @RequestBody Error err) {
        return service.update(id, err);
    }

    @DeleteMapping("/employee/{id}")
    public Mono<Void> deleteError(@PathVariable String id) {
        return service.delete(id);
    }

}
