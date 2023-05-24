package com.spring.webflux;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "WebFlux")
public class Error {

    @Id
    public String id;

    private String errorName;
    private String errorCode;
    private String errorDetail;
}
