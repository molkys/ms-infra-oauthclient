package com.example.infra.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * View Resolver configuration from Thymeleaf framework
 * @author orodr
 *
 */
@Configuration
public class ThymeleafViewResolverConfig {

	@Bean
    public ViewResolver thymeleafViewResolver() {
 
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
 
        viewResolver.setTemplateEngine(thymeleafTemplateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(0);
 
        // IMPORTANT: index* makes reference to the main page from the API documentation, 
        //	new keywords can be added by adding comma as string separator. Example: "index*", "th_*"
        //viewResolver.setViewNames(new String[] { "*" });
 
        return viewResolver;
    }
 
    // Thymeleaf template engine with Spring integration
    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
 
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        templateEngine.setEnableSpringELCompiler(true);
 
        return templateEngine;
    }
 
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        return new SpringResourceTemplateResolver();
    }
 
    // Thymeleaf template resolver serving HTML
    @Bean
    public ITemplateResolver thymeleafTemplateResolver() {
 
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
 
        templateResolver.setPrefix("templates/html/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
 
        return templateResolver;
    }
    
}
