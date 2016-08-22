package org.wso2.msf4j.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wso2.msf4j.example.interfaceController.IStudent;
import org.wso2.msf4j.example.model.DTO.StudentDTO;
import org.wso2.msf4j.example.service.StudentService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by Long on 8/22/2016.
 */
@Component
@Path("/db")
public class StudentController implements IStudent {

    @Autowired
    StudentService studentService;

    @GET
    @Path("/")
    public String abc() {
        return "a";
    }

    @GET
    @Path("/{amount}")
    public List<StudentDTO> getAll(@PathParam("amount") int amount) {
        return studentService.getAll(amount);
    }

}
