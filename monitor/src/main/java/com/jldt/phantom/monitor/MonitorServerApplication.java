package com.jldt.phantom.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class MonitorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorServerApplication.class, args);
    }

}
