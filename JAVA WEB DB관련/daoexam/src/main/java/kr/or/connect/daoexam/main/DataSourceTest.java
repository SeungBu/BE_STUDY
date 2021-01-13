package kr.or.connect.daoexam.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
//DBConfig 잘 동작되는지 확인하기위한 class임
public class DataSourceTest {

	//ApplicationConfig에 들어있는 설정파일을 읽어서 ApplicationContext를 생성
	//ApplicationContext가 Ioc(DI컨테이너)인 거임
	//이 컨테이너가 갖고있는 getBean메소드를  이용해서 datasource클래스를 요청하고 이 객체를 리턴해줄거임
	//이를 이용해서 getConnection하는거임
	public static void main(String[] args) {
		//공장인 ac만듦 = 어노테이션confiog
		//dbconfig 정보를 알려주는게아니라 applicationconfig파일에 이지 dbconfig를 import 해놨기 때문에 applicationConfig파일만 알려주면됨 여기서읽어서 필요한 공장을 만들어줄거임
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class);//공장을 통해서 datasource객체 얻어내면됨,getBean해오면됨
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null)
				System.out.println("접속 성공^^");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}