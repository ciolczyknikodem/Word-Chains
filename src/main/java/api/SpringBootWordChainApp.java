package api;

import controller.WordChainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = WordChainController.class)
public class SpringBootWordChainApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWordChainApp.class, args);
    }
}
