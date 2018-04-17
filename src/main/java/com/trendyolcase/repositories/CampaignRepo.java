package com.trendyolcase.repositories;

import com.trendyolcase.models.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

//MongoRepository implements standart `crud` functionalities
public interface CampaignRepo extends MongoRepository<Campaign, String>{

    List<Campaign> findByTypeId(String typeId);

    List<Campaign> findByTypeIdIn(List<String> typeIds);

}
