package org.wso2.msf4j.example.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.interfaceController.IRam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


/**
 * Created by Longlaptop on 8/18/2016.
 */
@Component
@Path("/ram")
public class RamController implements IRam {
    //Implement InterfaceController

    @GET
    @Path("/{amount}/{length}")
    public String randomString5k1k(@PathParam("amount") int amount, @PathParam("length") int length) {
        for (int i = 0; i < amount; i++)
            RandomStringUtils.randomAlphanumeric(length);
        return "OK Ram" + amount + "with " + length;
    }


}
