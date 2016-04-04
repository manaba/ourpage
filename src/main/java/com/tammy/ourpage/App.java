package com.tammy.ourpage;

/**
 * Created by tammy on 16/4/4.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 主程序入口
 *
 */
@ImportResource(value = {"ApplicationContextBase.xml"})
@SpringBootApplication
public class App {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
    }

}

