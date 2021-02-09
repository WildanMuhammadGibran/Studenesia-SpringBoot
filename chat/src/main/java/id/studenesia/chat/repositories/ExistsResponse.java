package id.studenesia.chat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import id.studenesia.chat.models.Users;

@Repository
public interface ExistsResponse extends MongoRepository<Users, String> {
    
    Boolean existsByUsername(String username);
}
