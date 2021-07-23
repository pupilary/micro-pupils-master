package com.pupils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author takesi
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MicroCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroCloudGatewayApplication.class, args);
    }

}
