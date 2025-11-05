package br.com.nildosantos.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI cotiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Clientes - Nildo Santos")
                        .description("Documentação da API de Clientes desenvolvida por Nildo Santos com Spring Boot.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Nildo Santos")
                                .url("https://www.linkedin.com/in/nildo-santos/")
                                .email("nil-do-fox@hotmail.com"))
                        .license(new License()
                                .name("Licença MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }
}