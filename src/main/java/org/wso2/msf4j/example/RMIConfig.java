package org.wso2.msf4j.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.interfaceController.IDisk;
import org.wso2.msf4j.example.interfaceController.IRam;

/**
 * Created by hunghip on 7/23/2016.
 */
@Configuration
public class RMIConfig {
    private static final int PORT = 1098;

    @Autowired
    IRam iRam;

    @Autowired
    IDisk iDisk;

    @Bean
    public RmiServiceExporter diskCall(IDisk iDisk) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(iDisk);
        rmiServiceExporter.setServiceName("disk5k1k"); //Client gọi qua ServiceName
        rmiServiceExporter.setServiceInterface(IDisk.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter ramCall(IRam iRam) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setRegistryPort(PORT);
        rmiServiceExporter.setService(iRam);
        rmiServiceExporter.setServiceName("ram5k1k");
        rmiServiceExporter.setServiceInterface(IRam.class);
        return rmiServiceExporter;
    }

}
