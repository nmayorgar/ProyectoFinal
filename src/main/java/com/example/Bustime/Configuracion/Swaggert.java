package com.example.Bustime.Configuracion;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swaggert {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Bustime")
                        .version("1.0")
                        .description("Documentacion de la API para gestionar BD en Bustime")
                        .contact(new Contact()
                                .name("Soprte APi")
                                .email("nmayorgar@ucundinamarca.edu.co")));
    }
}
