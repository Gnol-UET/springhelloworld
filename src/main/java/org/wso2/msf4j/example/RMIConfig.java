package org.wso2.msf4j.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.wso2.msf4j.example.iController.IDisk;

/**
 * Created by hunghip on 7/23/2016.
 */
@ComponentScan
@Configuration
public class RMIConfig {
    private static final int PORT = 1098;

    //    @Bean
//    public RmiServiceExporter rmiServiceExporter(ICpu cpu) { //Truyen interface
//        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
//        rmiServiceExporter.setService(cpu);
//        rmiServiceExporter.setServiceName("TestCPU");
//        rmiServiceExporter.setServiceInterface(ICpu.class);
//        rmiServiceExporter.setRegistryPort(PORT);
//        return rmiServiceExporter;
//    }
    @Bean
    public RmiServiceExporter rmiServiceExportersdgaweg(IDisk iDisk) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(iDisk);
        rmiServiceExporter.setServiceName("disk5k1k"); //Client gọi qua ServiceName
        rmiServiceExporter.setServiceInterface(IDisk.class);
        rmiServiceExporter.setRegistryPort(PORT);
        return rmiServiceExporter;
    }

}
