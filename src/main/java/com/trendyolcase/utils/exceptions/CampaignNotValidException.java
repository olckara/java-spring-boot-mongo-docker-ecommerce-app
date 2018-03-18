package com.trendyolcase.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Campaign Not Valid")
public class CampaignNotValidException extends RuntimeException {
    public CampaignNotValidException() {
    }

    public CampaignNotValidException(String message) {
        super(message);
    }
}
