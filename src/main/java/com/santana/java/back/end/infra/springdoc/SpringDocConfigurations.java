package com.santana.java.back.end.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SpringDocConfigurations {
        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .addServersItem(new Server().url("http://api.medicos"))
                                .info(new Info()
                                                .title("JAVA-Microsservices SHOPPING-API")
                                                .version("v1")
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
