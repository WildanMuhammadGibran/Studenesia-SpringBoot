package id.studenesia.chat.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import id.studenesia.chat.models.StatusDaily;

@Repository
public interface StatusRepository extends MongoRepository<StatusDaily, String> {
    
   
}
