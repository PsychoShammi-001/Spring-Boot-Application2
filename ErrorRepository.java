package com.spring.webflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ErrorRepository extends ReactiveMongoRepository<Error, String> {
}
