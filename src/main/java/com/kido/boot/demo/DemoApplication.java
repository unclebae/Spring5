package com.kido.boot.demo;

import java.util.Locale;

import com.amazonaws.codeguru.agent.Profiler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class DemoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {

		var cpmtext = SpringApplication.run(DemoApplication.class, args);
		System.out.println(context);

	}

	@Bean
	public CustomizedErrorAttributes errorAttributes() {
		return new CustomizedErrorAttributes();
	}

	@Bean
	public LocaleResolver localeResolver1() {
		return new AcceptHeaderLocaleResolver();
	}

	@Bean
	public LocaleResolver localeResolver2() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("en"));
		return localeResolver;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		// resolver.setCookieName("language");
		// resolver.setCookieMaxAge(3600);
		// resolver.setDefaultLocale(new Locale("en"));

		return resolver;
	}

	@Bean
	public LocaleResolver localeResolver4() {
		FixedLocaleResolver fixedLocaleResolver = new FixedLocaleResolver();
		fixedLocaleResolver.setDefaultLocale(new Locale("en"));
		return fixedLocaleResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		return new LocaleChangeInterceptor();
	}

	// HTTP 와 HTTPS 모두 지원
	// @Bean
	// public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
	// var factory = new TomcatServletWebServerFactory();
	// factory.addAdditionalTomcatConnectors(httpConnector());
	// return factory;
	// }

	// private Connector httpConnector() {
	// var connector = new
	// Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
	// connector.setScheme("http");
	// connector.setPort(8080);
	// connector.setSecure(false);

	// return connector;
	// }

	// @Bean
	// public BeanPostProcessor addHttpConnectorProcessor() {
	// return new BeanPostProcessor() {
	// @Override
	// public Object postProcessBeforeInitialization(Object bean, String beanName)
	// throws BeansException {
	// if (bean instanceof TomcatServletWebServerFactory) {
	// var factory = (TomcatServletWebServerFactory) bean;
	// factory.addAdditionalTomcatConnectors(httpConnector());
	// }
	// return bean;
	// };
	// };
	// }

	// // HTTP를 HTTPS로 리다이렉션
	// @Bean
	// public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
	// var factory = new TomcatServletWebServerFactory();
	// factory.addAdditionalTomcatConnectors(httpConnector());
	// factory.addContextCustomizers(securityCustomizer());
	// return factory;
	// }

	// private Connector httpConnector() {
	// var connector = new
	// Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
	// connector.setScheme("http");
	// connector.setPort(8080);
	// connector.setSecure(false);
	// connector.setRedirectPort(8443);
	// return connector;
	// }

	// private TomcatContextCustomizer securityCustomizer() {
	// return context -> {
	// var securityConstraint = new SecurityConstraint();
	// securityConstraint.setUserConstraint("CONFIDENTIAL");
	// var collection = new SecurityCollection();
	// collection.addPattern("/*");
	// securityConstraint.addCollection(collection);
	// context.addConstraint(securityConstraint);
	// };
	// }

}
