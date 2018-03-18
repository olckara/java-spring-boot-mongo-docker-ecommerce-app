package com.trendyolcase.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Campaign Not Found")
public class CampaignNotFoundException extends RuntimeException {
    public CampaignNotFoundException() {
    }

    public CampaignNotFoundException(String message) {
        super(message);
    }
}
