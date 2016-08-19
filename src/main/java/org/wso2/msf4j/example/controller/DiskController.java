package org.wso2.msf4j.example.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.interfaceController.IDisk;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @GET
    @Path("/5000/1024")
    public String disk5k1k() {
        for (int i = 0; i < 5000; i++) {
            List<String> lines = Arrays.asList(RandomStringUtils.randomAlphanumeric(1024), "The second line");
            java.nio.file.Path file = Paths.get("disk 5k 1k/5k1k " + i + ".txt");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "OK Disk 50000 - 10240";

    }

    @GET
    @Path("/50000/10240")
    public String disk50k10k() {
        for (int i = 0; i < 50000; i++) {
            List<String> lines = Arrays.asList(RandomStringUtils.randomAlphanumeric(10240), "The second line");
            java.nio.file.Path file = Paths.get("disk 50k 10k/50k10k " + i + ".txt");
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "OK Disk 50000 - 10240";

    }
}
