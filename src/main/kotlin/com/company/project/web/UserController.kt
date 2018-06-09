package com.company.project.web

import com.company.project.dao.UserRepository
import com.company.project.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDateTime


/**
 * @author VincentLee
 */
@RepositoryRestController
class UserController {

    @Autowired
    private lateinit var repository: UserRepository

    @GetMapping("/c")
    @ResponseBody
    fun getProducers(): ResponseEntity<*> {
        val producers = repository.findAll()

        //
        // do some intermediate processing, logging, etc. with the producers
        //

        val resources = Resources<User>(producers)

        resources.add(linkTo(methodOn(UserController::class.java).getProducers()).withSelfRel())

        // add other links as needed

        return ResponseEntity.ok<Any>(resources)
    }

    @GetMapping("/users/u")
    fun user(): ResponseEntity<*> {
        val resource = Resource<LocalDateTime>(LocalDateTime.now())
        return ResponseEntity.ok<Any>(resource)
    }
}
