package kr.or.connect.guestbook2.dao;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook2.config.ApplicationConfig;
import kr.or.connect.guestbook2.dto.Guestbook;
import kr.or.connect.guestbook2.dto.Log;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		//테스트하기 위해서 일단은 뭐가 필요할 거냐면 ApplicationContext 필요
		//그리고 GuestbookDao를 불러내 오는 이러한 부분들이 필요하겠죠.
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
		
		Guestbook guestbook = new Guestbook();
		guestbook.setName("강경미3");
		guestbook.setContent("반갑습니다. 여러분2.");
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		System.out.println("id : " + id);
		
		LogDao logDao = ac.getBean(LogDao.class);
		Log log = new Log();
		log.setIp("127.0.0.1");
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
	}
//지금까지 Repository Layer 쪽을 지금 작성을 해보신 거예요.
}