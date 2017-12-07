package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"example"})
@SpringBootApplication
public class SampleSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootApplication.class, args);
    }
}