package org.wso2.msf4j.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.interfaceController.IRsa;
import org.wso2.msf4j.example.service.RSAService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.security.GeneralSecurityException;

/**
 * Created by Longlaptop on 8/18/2016.
 */
@Component
@Path("/rsa")
public class RSAController implements IRsa {

    @Autowired
    private RSAService rsaService;

    //Độ dài key: 512, 1024, 2048
    @GET
    @Path("/5000/512")
    public void RSA512() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            rsaService.RSAcrypto(512, keyexist);
            keyexist = false;
        }
    }

    @GET
    @Path("/5000/1024")
    public void RSA1024() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            rsaService.RSAcrypto(1024, keyexist);
            keyexist = false;
        }
    }

    @GET
    @Path("/5000/2048")
    public void RSA2048() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            rsaService.RSAcrypto(2048, keyexist);
            keyexist = false;
        }

    }

}
