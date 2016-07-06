package com.tammy.ourpage;

/**
 * Created by tammy on 16/4/4.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.MultipartConfigElement;

/**
 * 主程序入口
 *
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
@ImportResource(value = {"classpath:/ApplicationContextBase.xml"})
@SpringBootApplication
public class App extends SpringBootServletInitializer{

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("5120MB");
        factory.setMaxRequestSize("5120MB");
        return factory.createMultipartConfig();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder 	application) {
        return application.sources(App.class);
    }

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
    }

}

