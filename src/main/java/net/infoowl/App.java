package net.infoowl;

/**
 * Created by caneraydinbey on 25.08.2016.
 */


        import org.springframework.boot.web.support.SpringBootServletInitializer;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.autoconfigure.web.ErrorController;
        import org.springframework.boot.builder.SpringApplicationBuilder;

        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}


//takes input and navigates to that address
@RestController
class GreetingController {

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, welcome " + name + "!";
    }
}

@RestController
class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "You wanted to go to invalid URL. Please check again.";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}