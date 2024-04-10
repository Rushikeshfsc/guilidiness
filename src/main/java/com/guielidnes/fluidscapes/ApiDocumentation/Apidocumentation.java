package com.guielidnes.fluidscapes.ApiDocumentation;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Apidocumentation extends WebMvcConfigurerAdapter {

	
	private final String servicetitle="Guidelines ";
	
	private final String servicedescription="This Api Documentation is for Guidelines";
	
	public Docket api() {
return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors.basePackage("com.guielidnes.fluidscapes.controller"))
		.paths(PathSelectors.any()).build().apiInfo(ApiInfo());
		
		
	}

	private ApiInfo ApiInfo() {
		
		return new ApiInfoBuilder().title(servicetitle).description(servicedescription).build();
	}
	
	
	public void addResourcehandler(ResourceHandlerRegistry handlerRegistry) {
		
		handlerRegistry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resource");
		handlerRegistry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resource/webjars");
	}
	
}
