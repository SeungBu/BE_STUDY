package kr.or.connect.guestbook2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.guestbook2.dao",  "kr.or.connect.guestbook2.service"}) 
//여기서는 dao나 service에 구현되어 있는 컴포넌트들을 읽어오면 될 거니까 basePackages에다가 각각의 패키지를 지정하고 있는 것을 볼 수 있을 거고요.
//이제 이것들이 수행될 때 내부적으로 DBConfig에 사용되고 있는 것들을 써야 될 거니까 해당 부분을 @Import 하고 있는 것을 확인할 수가 있겠죠.
@Import({ DBConfig.class })
public class ApplicationConfig {

}