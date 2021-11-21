package br.com.javamodas.controller.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket config(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.javamodas"))
                .build()
                .apiInfo(apiInformation());
    }

    private ApiInfo apiInformation() {
        return new ApiInfoBuilder()
                .title("Java Modas")
                .description("Uma loja de roupas de MUUUITA classe")
                .version("1.0.0")
                .build();
    }
}