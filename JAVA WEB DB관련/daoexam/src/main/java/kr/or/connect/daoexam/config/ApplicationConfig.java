package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration //이 클래스에 configration이라는 걸알려줘서 실행되면서 여기에 있는 설정을 읽어들일거임
@Import({DBConfig.class}) //import 어노테이션이용하면 설정파일을 여러개 나눠서 사용가능, ex)데이터 연결 컨피그는 따로할수있음
//DBconfig를 따로 이용해서 따로 설정해줄거라는말임
@ComponentScan(basePackages = { "kr.or.connect.daoexam.dao" }) //약속된 어노테이션을 찾아 스캔해달라, 베이스페키지이용해야 이런 패키지여러개나열가능
//이렇게 해야roledao에있는 repository를 등록해줌
public class ApplicationConfig {

}