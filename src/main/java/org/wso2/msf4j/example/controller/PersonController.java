package org.wso2.msf4j.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.wso2.msf4j.example.model.DTO.PersonDTO;
import org.wso2.msf4j.example.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by MinhTu on 8/15/2016.
 */

@Component
@Path("/db")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GET
    @Path("/json/{amount}")
    public List<PersonDTO> getListPerson(@PathParam("amount") int amount){
        return personService.getListPerson(amount);
    }

    @GET
    @Path("db-json/all")
    public List<PersonDTO> getListPerson(){
        return personService.getAll();
    }


}
