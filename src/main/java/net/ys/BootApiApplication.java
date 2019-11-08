package net.ys;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@EnableRabbit
@Controller
@SpringBootApplication
public class BootApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApiApplication.class, args);
    }

    @GetMapping("/")
    public String doGet() {
        return "login";
    }
}
