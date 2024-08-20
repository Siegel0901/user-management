package top.siegel.usermanagement.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @projectName: user-management
 * @package: top.siegel.usermanagement.config
 * @className: SwaggerConfig
 * @author: Siegel
 * @createDate: 2024/8/20
 * @createTime: 19:10
 * @description: SwaggerConfig
 */
@EnableSwagger2
@Configuration
@EnableKnife4j
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("Siegel", "https://www.siegel.top", "xuguiqian0901@163.com");
        return new ApiInfo("Api Documentation",
                "用户管理系统api",
                "1.0",
                "https://www.siegel.top",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}


