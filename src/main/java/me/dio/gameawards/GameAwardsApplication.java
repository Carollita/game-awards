package me.dio.gameawards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Game Awards Api", description = "API for ranking games."))
public class GameAwardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameAwardsApplication.class, args);
	}

}
