package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@ComponentScan해놨으면 클래스 위에 이렇게 해주면됨
@Component
public class Car {
	//@ComponentScan붙었으면 setEngine없애고 autowired 붙이면 알아서 아래에있는 Engine이란 객체 주입 해줌 
	@Autowired
	private Engine v8;
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	public void setEngine(Engine e) {
		this.v8 = e;
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
	/*
	 * 이부분 자체를 IoC이용할거임 스프링 컨테이거너가 하도록 할거임
	 * 설정파일에 해당 bean들을 등록해야됨
	public static void main(String[] args) {
		Engine e = new Engin();
		Car c = new Car();
		c.setEngine(e);
		//여기까지가 
		 * <bean id="e" class="kr.or.connect.diexam01.Engine"></bean>
<bean id="c" class="kr.or.connect.diexam01.Car">
	<property name="engine" ref="e"></property>
	여기까지 수행한거랑 같음
		c.run();
	}
	*/
}
