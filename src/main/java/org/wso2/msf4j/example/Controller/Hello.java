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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.exception.InvalidNameException;
import org.wso2.msf4j.example.service.HelloService;
import org.wso2.msf4j.example.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * MSF4J service class annotated with MSF4J and Spring annotations.
 */
@Component
@Path("/hello")
public class Hello {

    @Autowired
    private HelloService helloService;

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
