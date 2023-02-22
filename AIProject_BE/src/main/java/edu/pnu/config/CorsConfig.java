package edu.pnu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:3000", "http://3.35.179.46:3000");
//			.allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE");
	}
	
}

//한 웹 어플리케이션이 다른 출처에 존재하는 자원에 접근하고 싶다면? 
//접근 권한을 줄 수 있도록 브라우저에 알려주는 체제인 CORS를 이용해야 한다. 
//예를 들어 한 컴퓨터의 로컬에서 Spring Boot를 8080 포트로 띄우고, React를 3000 포트로 띄웠다고 가정하자. 
//이 둘은 포트가 다르므로 다른 출처임을 알 수 있다. React가 Spring Boot의 API를 호출하려고 할 때, 
//출처가 다르므로 접근 권한이 없다며 CORS 에러가 발생한다.

//이 CORS를 확인하는 로직이 서버가 아닌 브라우저에 구현되어있다는 점이다. 
//그러므로 Postman 같은 툴을 이용해 API 요청을 보낼 때는 CORS 에러가 발생하지 않는다.

//https://yeonyeon.tistory.com/236
