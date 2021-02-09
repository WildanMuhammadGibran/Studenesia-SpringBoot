package id.studenesia.chat.repositories;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import id.studenesia.chat.models.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, Long>{

   // Optional<Users> findByIdUser(Long id);
}
