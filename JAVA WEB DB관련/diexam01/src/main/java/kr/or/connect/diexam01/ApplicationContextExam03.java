package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

	public static void main(String[] args) {
		//xml할떄는 classpath를 읽어와서 했었는데
		//이제는 이렇게만 하면됨
		//class파일을 읽어들이게만 해주면 됨
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		   
		//클래스 메소드의 이름 car넣거나
		//Car.class 처럼 클래스 이름 넣어도됨   Car car = (Car)ac.getBean(" Car.class");
		Car car = (Car)ac.getBean("car");
		car.run();
		
	}
}