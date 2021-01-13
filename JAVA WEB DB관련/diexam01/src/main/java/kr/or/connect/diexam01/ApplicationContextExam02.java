package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext( 
				"classpath:applicationContext.xml"); 

		//자동차 객체 생성을 내가하는게 아니라 스프링컨테이너가 해줄꺼니까 ac에 부탁
		//bean id 를 넣어주면됨
		Car car = (Car)ac.getBean("car"); 
		car.run();
		
	}
}