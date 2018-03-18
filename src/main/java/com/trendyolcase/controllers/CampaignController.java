package com.trendyolcase.controllers;

import com.trendyolcase.models.Campaign;
import com.trendyolcase.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/campaign/")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @GetMapping
    public ResponseEntity<List<Campaign>> getAll() {
        return new ResponseEntity<>(campaignService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Campaign> get(@PathVariable("id") String id) {
        return new ResponseEntity<>(campaignService.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Campaign> create(@RequestBody Campaign campaign) {
        return new ResponseEntity<>(campaignService.create(campaign), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Campaign> update(@PathVariable("id") String id, @RequestBody Campaign campaign) {
        return new ResponseEntity<>(campaignService.update(id, campaign), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        return new ResponseEntity<>(campaignService.delete(id), HttpStatus.OK);
    }
}
