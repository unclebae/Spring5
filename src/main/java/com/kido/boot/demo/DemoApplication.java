package com.kido.boot.demo;

import java.util.Locale;

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
		SpringApplication.run(DemoApplication.class, args);
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

	
}
