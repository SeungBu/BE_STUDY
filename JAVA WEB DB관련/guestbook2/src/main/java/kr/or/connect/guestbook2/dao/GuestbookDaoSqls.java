package kr.or.connect.guestbook2.dao;

public class GuestbookDaoSqls {//query들은 상수로 관리
	public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
	//mysql query 중에 limit를 이용하시면 시작 값, 끝날 때의 값 이런 것들을 설정해서 특정한 부분만 select 해오는 이런 부분들을 수행할 수가 있어요.
	public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";
}