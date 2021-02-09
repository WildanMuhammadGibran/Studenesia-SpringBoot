package id.studenesia.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.studenesia.chat.models.StatusDaily;
import id.studenesia.chat.models.Users;

@RestController
@RequestMapping("/studenesia")
public class StatusController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping(value = "/user/status/{id}/{id_status}")
    public void findStatusUserById(@PathVariable(value = "id") Long id,
            @PathVariable(value = "id_status") String id_status) {

                Query query = new Query();
                query.addCriteria(Criteria.where("id").is(id).and("status_daily").elemMatch(Criteria.where("id_status").is(id_status)));

                mongoTemplate.find(query, Users.class);

    } 

    @PostMapping(value = "/user/status/create/{id}")
    public void postStatusUser(@PathVariable(value = "id") Long id, @RequestBody StatusDaily statusDaily) {

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.push("status_daily", statusDaily);
        
        mongoTemplate.updateFirst(query, update, Users.class);

    }


}
