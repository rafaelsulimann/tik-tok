package com.sulimann.tiktok.utils.http;

import org.springframework.http.HttpMethod;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Delete extends HttpPadrao {

    @Override
    protected HttpMethod method() {
        return HttpMethod.DELETE;
    }

}

