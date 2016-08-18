package org.wso2.msf4j.example.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


/**
 * Created by Longlaptop on 8/18/2016.
 */
@Component
@Path("/ram")
public class RamController {

    @GET
    @Path("/5000/1024")
    public String randomString5k1k() {
        for (int i = 0; i < 5000; i++)
            RandomStringUtils.randomAlphanumeric(1024);
        return "OK Ram 5000 - 1024";
    }

    @GET
    @Path("/50000/10240")
    public String randomString50k10k() {
        for (int i = 0; i < 50000; i++)
            RandomStringUtils.randomAlphanumeric(10240);
        return "OK Ram 50000 - 10240";
    }


}
