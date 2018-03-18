package com.trendyolcase.repositories;

import com.trendyolcase.models.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;

//MongoRepository implements standart `crud` functionalities, and that's all I need
public interface CampaignRepo extends MongoRepository<Campaign, String>{

}
