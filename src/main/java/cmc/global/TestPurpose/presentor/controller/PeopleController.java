package cmc.global.TestPurpose.presentor.controller;

import cmc.global.TestPurpose.entity.People;
import cmc.global.TestPurpose.repository.PeopleCustomRepository;
//import cmc.global.TestPurpose.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {

//    @Autowired
//    private PeopleRepository peopleRepository;

    @Autowired
    private PeopleCustomRepository peopleCustomRepository;
    @PostMapping
    public Object saveUser(@Validated @RequestBody People people) {
        peopleCustomRepository.save(people);
        return "OK";
    }
}
