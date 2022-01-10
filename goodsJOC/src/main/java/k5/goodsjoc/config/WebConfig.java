package k5.goodsjoc.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import k5.goodsjoc.interceptor.CommonInterceptor;
import k5.goodsjoc.interceptor.LoginInterceptor;

public class WebConfig implements WebMvcConfigurer{
	private final CommonInterceptor commonInterceptor;
	private final LoginInterceptor loginInterceptor;
	public WebConfig(CommonInterceptor commonInterceptor, LoginInterceptor loginInterceptor) {
			this.commonInterceptor = commonInterceptor;
			this.loginInterceptor = loginInterceptor;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/image/**")
				.excludePathPatterns("/dist/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/favicon.ico");
		
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/image/**")
				.excludePathPatterns("/dist/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/favicon.ico")
				.excludePathPatterns("/system_management/user/userInsert")
				.excludePathPatterns("/system_management/user/loginForm")
				.excludePathPatterns("/system_management/user/logout");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
