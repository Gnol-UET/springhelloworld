package org.wso2.msf4j.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.interfaceController.IDisk;
import org.wso2.msf4j.example.interfaceController.INetio;
import org.wso2.msf4j.example.interfaceController.IPerson;
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

    @Autowired
    IPerson iPerson;

    @Autowired
    INetio iNetio;

    @Bean
    public RmiServiceExporter disk5kCall(IDisk iDisk) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(iDisk);
        rmiServiceExporter.setServiceName("RMIDisk"); //Client gọi qua ServiceName
        rmiServiceExporter.setServiceInterface(IDisk.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter ram5kCall(IRam iRam) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setRegistryPort(PORT);
        rmiServiceExporter.setService(iRam);
        rmiServiceExporter.setServiceName("RMIRam");
        rmiServiceExporter.setServiceInterface(IRam.class);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter person(IPerson iPerson) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setRegistryPort(PORT);
        rmiServiceExporter.setService(iPerson);
        rmiServiceExporter.setServiceName("RMIPerson");
        rmiServiceExporter.setServiceInterface(IPerson.class);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter netio(INetio iNetio) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setRegistryPort(PORT);
        rmiServiceExporter.setService(iNetio);
        rmiServiceExporter.setServiceName("RMINetio");
        rmiServiceExporter.setServiceInterface(INetio.class);
        return rmiServiceExporter;
    }



}
