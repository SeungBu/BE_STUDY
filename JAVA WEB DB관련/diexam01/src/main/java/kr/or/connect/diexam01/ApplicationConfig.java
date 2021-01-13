package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//의존성 주입을 java config를 이용하여도 할 수 잇음 xml에 bean등록 말고. 어노테이션과 자바컨피스파일을 이용해서도 가능

////가장 먼저할일은 클래스위에 나는 컨피그 파일이라는걸 알려야됨
//그것을 알려주는 어노테이션이 이거임 이거를 읽어서 해당 클래스가 컨피스 파일이라는 걸 알수있음 
//그러고 빈등록

//jdk5부터 @는 자바 어노테이션임  컨파일,런타임시 해석될수있음
@Configuration
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
