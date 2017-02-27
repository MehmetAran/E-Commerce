package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by gennt on 2/23/2017.
 */
@SpringBootApplication
public class ECommerceApp {
    public static void main(String[] args) {
        SpringApplication.run(ECommerceApp.class, args);
    }
}
