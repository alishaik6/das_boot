package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Hello world!
 *
 */
// for embedded tomcat
//@SpringBootApplication
////@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
//public class App 
//{
//    public static void main( String[] args )
//    {
//        SpringApplication.run(App.class, args);
//    }
//}	

@Configuration
@ComponentScan
@EnableAutoConfiguration

public class App  extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<App> applicationClass = App.class;
}
