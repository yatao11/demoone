package com.demoone.config.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/14 09:58
 */
@EnableSwagger2 // 使swagger2生效
@Configuration // 配置注解，自动在本类上下文加载一些环境变量信息
public class Swagger2 {
//	@Bean
//	public Docket createYuntuApi() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//				.apis(RequestHandlerSelectors.basePackage("com.demoone"))
//				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
//	}
//
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("站长小工具对外接口 Rest API").version("1.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").license("Apache 2.0")
				.description("此API为开发人员，测试人员，UI人员提供方便快捷的API开发，测试体验").build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) .apiInfo(apiInfo()) .select()
		// 自行修改为自己的包路径
		.apis(RequestHandlerSelectors.basePackage("com.demoone")) .paths(PathSelectors.any()) .build();
	}

}
