package kr.or.connect.guestbook2.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.guestbook2.dao.GuestbookDao;
import kr.or.connect.guestbook2.dao.LogDao;
import kr.or.connect.guestbook2.dto.Guestbook;
import kr.or.connect.guestbook2.dto.Log;
import kr.or.connect.guestbook2.service.GuestbookService;
//구현하는 클래스는 impl에다가 작성을 해주시면 되고요.
//DAO는 @Repository라는 어노테이션을 붙여줬다면
//@Service 서비스 쪽에다가는 @Service라는 어노테이션을 이렇게 붙여주시면 돼요.
@Service//그러면 이게 지금 Service Layer에 해당하는 거예요.
public class GuestbookServiceImpl implements GuestbookService{ //  Impl은 뭘 구현하기로 했었냐면 GuestbookService를 구현 , 해당 메서드들을 모두 Implement를 시켜야겠죠
	@Autowired//Bean 자동으로 등록해주는 어노테이션
	GuestbookDao guestbookDao; //나는 GuestbookDao를 guestbookDao라고 이용할 거예요.
	//알아서 생성해서 주입
	
	@Autowired
	LogDao logDao;

	//이때 이 메서드는 읽기만 하는 메서드잖아요? 그래서 읽기만 하는 메서드는 트랜잭션을 처리할 때
	//@Transactional이라는 어노테이션을 붙여주시면 내부적으로 readOnly라는 형태로 connection을 사용하게 돼요.
	@Override
	@Transactional
	public List<Guestbook> getGuestbooks(Integer start) { //해당 메서드가 수행이 되면 guestbook 목록 가져오겠죠?
		//이때 start 받아오면 우리 페이징 처리했을 때 시작되는 것부터 몇 개 이렇게 가져올 수 있도록 수행
		List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		//limit 부분은 몇 개를 가져올 거예요? 지금 이런 부분인데요.
		return list; // 이 부분이 List를 리턴할 거고요. 이 List는 Guestbook list를 나한테 주겠죠?
	}

	
	//메서드 같은 경우는 readOnly는 아니에요.
	//그래서 이때는 readOnly로 수행되면 트랜잭션이 적용이 안 될 거거든요.
	//그래서 @Transactional이라는 어노테이션에 (readOnly=false)로 지정하는 일을 수행하시면 됩니다
	@Override
	@Transactional(readOnly=false)
	public int deleteGuestbook(Long id, String ip) {
		//guestbookDao에 deleteById 라는 메서드 있었잖아요? 이거 이용
		// 입력받아온 id에 해당하는 값을 가지고 삭제
		int deleteCount = guestbookDao.deleteById(id);
		//이제 이 삭제가 제대로 일어났을 때 우리한테 1이라는 값을 리턴하게 되겠죠?
		Log log = new Log();// Log에 어떤 정보를 남길지 이런 부분
		log.setIp(ip);
		log.setMethod("delete");//현재 이 메서드는 delete가 수행됐었으니까
		log.setRegdate(new Date());
		logDao.insert(log);
		return deleteCount;
		//
	}

	@Override
	@Transactional(readOnly=false)//이렇게 이제 수행하시는데 add 메서드에도 잊어버리시면 안 되는 게 readOnly 속성을 false로 바꿔주셔야지 DB에 제대로 입력이 되겠죠.
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
								//guestbook 정보는 앞에 컨트롤러 단에서 아마 넘겨줬을 거예요. 컨트롤러 단에는 클라이언트한테 받아온 정보들을 담고 있었을 거고요.		
	//이 서비스가 다 나눌 수 없는 하나의 작업 단위 라고 이야기했었잖아요?
		//insert됐어도 중간에 그만두면 insert취소됨 트랙잭션 처리때문에 이렇게 됨
		//@transactional 취소하고 실행하면 위에는 오류전까지는 insert됨
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id);//이렇게 넣어주는 이유는 log에 남겨주기위해서임.
		
//		if(1 == 1)
//			throw new RuntimeException("test exception");
//			
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date()); //실제 실행되는시간~
		logDao.insert(log);
		
		
		return guestbook;
	}

	@Override
	public int getCount() {
		// getCount() 같은 경우는 페이징 처리 같은 거 하기 위해서
		//전체 몇 건이야. 이거 얻어오는 거잖아요?
		//우리 guestbookDao에 selectCount() 라는 메서드 구현해 놓았거든요
		//이런 selectCount() 이용하시면 해당 부분도 처리할 수 있겠죠.
		return guestbookDao.selectCount();
	}
	
	
}