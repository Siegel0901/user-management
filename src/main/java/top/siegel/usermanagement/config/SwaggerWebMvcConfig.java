package top.siegel.usermanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @projectName: user-management
 * @package: top.siegel.usermanagement.config
 * @className: SwaggerWebMvcConfig
 * @author: Siegel
 * @createDate: 2024/8/20
 * @createTime: 19:08
 * @description: SwaggerWebMvcConfig
 */
@Configuration
public class SwaggerWebMvcConfig  extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
