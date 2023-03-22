package com.santana.java.back.end.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("JAVA-Microsservices SHOPPING-API")
                        .description(
                                "API Rest da aplicação SHOPPING, contendo as funcionalidades de CRUD de compras")
                        .contact(new Contact()
                                .name("Crystyan")
                                .email("backend@voll.med"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://cryss.dev/api/licenca")));

    }

}
