package br.com.progweb.dinheiros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;

@Configuration
@EnableSwagger2
public class SwaggerConfig {  
      
    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String TITLE = "Dinheiros REST API";
    private static final String DESC = "RESTful API para dinheiros";
    // TODO: apontar para a home do front
    private static final String HOMEPAGE = "";
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESC)
                .contact(new Contact("m, r", HOMEPAGE, "m.gregorio@aluno.ufabc.edu.br"))
                .version(SWAGGER_API_VERSION)
                .build();
        
    }
    
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes()
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.any())//regex("/.*/v.*/.*"))
                .build();
                
    }
                                  
    // @Bean
    // public Docket api() { 
    //     return new Docket(DocumentationType.SWAGGER_2)  
    //       .select()                                  
    //       .apis(RequestHandlerSelectors.any())              
    //       .paths(PathSelectors.any())                          
    //       .build();                                           
    // }
}
