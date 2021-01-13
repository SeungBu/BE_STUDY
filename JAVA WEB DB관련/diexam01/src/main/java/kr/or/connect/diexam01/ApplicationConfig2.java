package kr.or.connect.diexam01;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("kr.or.connect.diexam01")
//알아서 너가 여기에있느 것들 읽어서 등록해.
//어노테이션 알아서 다 찾아서 등록하라는 거임
//너무 광범위해서 컨포넌트랑 패키지 명 알려줘야됨
//해당 패키지안에서 스캔해라. 어노테이션 붙어잇으면 알아서 등록해.
//이러고나서 각 클래스 위에 @Component 붙여주면 됨
public class ApplicationConfig2 {
}