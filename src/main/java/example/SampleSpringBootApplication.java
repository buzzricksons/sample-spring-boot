package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"example"})
@SpringBootApplication
public class SampleSpringBootApplication {
//public class SampleSpringBootApplication extends SpringBootServletInitializer {
//    /**
//     * If you packaging build result to war file, delete this comment out.
//     * And add below to build.gradle file.
//     *
//     * dependencies {
//     *   providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
//     * }
//     *
//     * @param application
//     * @return
//     */
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(SampleSpringBootApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootApplication.class, args);
    }
}