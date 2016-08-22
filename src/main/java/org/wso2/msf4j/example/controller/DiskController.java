package org.wso2.msf4j.example.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.interfaceController.IDisk;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.nio.charset.Charset;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Longlaptop on 8/18/2016.
 */
@Component
@Path("/disk")
public class DiskController implements IDisk {
    //Implement InterfaceController
    @Override
    @GET
    @Path("/{amount}/{length}")
    public String disk5k1k(@PathParam("amount") int amount, @PathParam("length") int length) {
        for (int i = 0; i < amount; i++) {
            List<String> lines = Arrays.asList(RandomStringUtils.randomAlphanumeric(length), "The second line");
            java.nio.file.Path file = Paths.get("disk 5k 1k/5k1k " + i + ".txt");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "OK Disk" + amount + " with" + length;
    }
}
