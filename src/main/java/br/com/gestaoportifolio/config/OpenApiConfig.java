package br.com.gestaoportifolio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        System.out.println("Swagger Config Loaded"); // Debug
        return new OpenAPI()
                .info(new Info()
                        .title("Gestão de Portfólio API")
                        .version("1.0")
                        .description("API para gerenciamento de membros do portfólio."));
    }
}