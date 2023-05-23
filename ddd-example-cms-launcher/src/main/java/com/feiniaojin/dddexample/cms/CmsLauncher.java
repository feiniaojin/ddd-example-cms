package com.feiniaojin.dddexample.cms;

import com.feiniaojin.gracefulresponse.EnableGracefulResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGracefulResponse
public class CmsLauncher {
    public static void main(String[] args) {
        SpringApplication.run(CmsLauncher.class, args);
    }
}