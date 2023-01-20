package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
@Configuration
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	public class swaggerui {
		
		@Bean
		public Docket swaggerApiConfig(){
			return new Docket(DocumentationType.SWAGGER_2)
			             .select()
			             .paths(PathSelectors.any())
			             .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
			             .build().apiInfo(metaInfo());
	    }

	    private ApiInfo metaInfo() {

	        return new ApiInfoBuilder()
	                .title("Atividades API REST")
	                .description("\"API Rest Swagger.\"")
	                .version("1.0")
	                .license("Apache License Version 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html\"")
	                .contact(new Contact("code java","localhost:8080"," apiteam@swagger.io"))
	                .build();
	    }
	}
}

