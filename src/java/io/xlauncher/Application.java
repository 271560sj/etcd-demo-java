package io.xlauncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args)throws Exception{
        SpringApplication.run(Application.class,args);
    }
}
