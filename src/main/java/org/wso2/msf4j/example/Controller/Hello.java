/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.msf4j.example.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.wso2.msf4j.example.exception.InvalidNameException;
import org.wso2.msf4j.example.service.HelloService;
import org.wso2.msf4j.example.model.User;
import org.wso2.msf4j.example.service.RSAService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 * MSF4J service class annotated with MSF4J and Spring annotations.
 */
@Component
@Path("/hello")
public class Hello {

    @Autowired
    private HelloService helloService;








    @GET
    @Path("/sleep/{time}")
    public String sleepplease(@PathParam("time") int time) throws InterruptedException {
         helloService.sleepplease(time);
        return "Slept for "+time;
    }
    @POST
    @Path("/simpleFormWithFormParam")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response simpleFormWithFormParam(User user) {
        return Response.ok().entity("Name and age " + user.getFirstName() + ", " + user.getLastName()).build();
    }
    @GET
    @Path("/id/{id}")
    public Response getUser(@PathParam("id") long id) {
        User user = helloService.getUser(id);
        if (user != null) {
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name) throws InvalidNameException {
        return helloService.hello(name);
    }

}
