package id.studenesia.chat.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.studenesia.chat.models.Users;
import id.studenesia.chat.repositories.ExistsResponse;
import id.studenesia.chat.repositories.UsersRepository;

@RestController
@RequestMapping("/studenesia")
public class UsersController {

    @Autowired
    public UsersRepository usersRepository;

    @Autowired
    public ExistsResponse existsResponse;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping(value = "/user/all")
    public List<Users> getAllUsers() {

        return usersRepository.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public Optional<Users> getById(@PathVariable(value = "id") Long id) {

        return usersRepository.findById(id);
    }

    @PostMapping(value = "/user/create")
    public String createUser(@RequestBody Users users) {
        if (existsResponse.existsByUsername(users.getUsername())) {

            return "Username Already Taken";
        } else {
            Users createUser = usersRepository.save(users);
            return "User created " + createUser.getUsername();
        }

    }

    @PutMapping(value = "/user/put/{id}")
    public ResponseEntity<Users> putById(@PathVariable(value = "id") Long id, @RequestBody Users users) {

        Optional<Users> _users = usersRepository.findById(id);

        Users putUser = _users.get();
        putUser.setUsername(users.getUsername() != null ? users.getUsername() : putUser.getUsername());
        putUser.setPhone_number(users.getPhone_number() != null ? users.getPhone_number() : putUser.getPhone_number());
        putUser.setStatus_online(users.isStatus_online());
        putUser.setProfile_img(users.getProfile_img() != null ? users.getProfile_img() : putUser.getProfile_img());
        putUser.setBio(users.getBio() != null ? users.getBio() : putUser.getBio());
        putUser.setBirthday(users.getBirthday() != null ? users.getBirthday() : putUser.getBirthday());

        return new ResponseEntity<>(usersRepository.save(putUser), HttpStatus.OK);
    }

    

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable("id") Long id) {
        try {
          usersRepository.deleteById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/user/delete/all")
    public ResponseEntity<Users> deleteAllUsers() {
        try {
          usersRepository.deleteAll();
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
