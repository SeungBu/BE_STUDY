package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		//공장 classpath:applicationContext.xml에 bean을 넣어놨으니까 이거 읽어서 자동으로해주라
		//
		ApplicationContext ac = new ClassPathXmlApplicationContext( 
				"classpath:applicationContext.xml"); 
		System.out.println("초기화 완료.");
		
		//오브젝트 타입으로 리턴해줘서 형변환필요, 해당 xml에서 id가 userBean과 일치하면 class이름 써있는대로 알아내서 일을 수행해줌
		UserBean userBean = (UserBean)ac.getBean("userBean");
		userBean.setName("kim");
		System.out.println(userBean.getName());
		
		//싱글턴 패턴으로 공장을 이용해서 생성,관리하기때문임. 여러번했다고 여러개를 해주는게아니라 하나를 이용해서 계쏙해줌
		//계쏙 getBean해도 계속만드는게 아니라 하나 만든 bean을 이용
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스이다.");
		}
		
	}
}