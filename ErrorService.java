package com.spring.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ErrorService {
    @Autowired
    public ErrorRepository errrepo;

    public Mono<Error> create(Error err) {
        return errrepo.save(err);
    }

    public Flux<Error> getAll() {
        return errrepo.findAll();
    }

    public Mono<Error> getById(String id) {
        return errrepo.findById(id);
    }

    public Mono<Error> update(String id, Error err) {
        err.setId(id);
        return errrepo.save(err);
    }

    public Mono<Void> delete(String id) {
        return errrepo.deleteById(id);
    }
}
