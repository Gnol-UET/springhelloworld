package org.wso2.msf4j.example.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.interfaceController.INetio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Long on 8/22/2016.
 */
@Component
@Path("/netio")
public class NetioController implements INetio {
    @GET
    @Path("/{length}")
    @Override
    public String getString(@PathParam("length") int length) {
        String a = RandomStringUtils.randomAlphanumeric(length);
        return a;
    }
}
