package kr.or.connect.daoexam.dao;

import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;

@Repository //Dao객체는 저장소 역할을 한다 해서@Repository 를 붙임
public class RoleDao { //Data Access할수있는 오브젝트임 해당 클래스
	private NamedParameterJdbcTemplate jdbc; //이미 구현되어있는 객체들임 spring JDBC를 편하게 하기위해 이미구현되어있음
	//select 해올떄는 NamedParameterJdbcTemplate객체 필요  (NamedParameterJdbcTemplate 내용보면앎)
	//바인딩할때 ?사용하면 문자열보면 알아보기힘드니까 NamedParameterJdbcTemplate이용,이름을 이용해서 바인딩하거나 결과값갖고올때 사용
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

	public RoleDao(DataSource dataSource) { //bean등록했던애(dataSource)가 자동으로 등록됨
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");
	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);//복잡한건 jdbc가 다해줄거임
		//비어있는 맵객체선언(Collections.emptyMap()) sql문제 바인딩할값있으면 그걸 전달하기 위하여 사용하는거임
		//select 한거한건의 결과를 dto에 저장하는 목적으로 사용,  BeanPropertyRowMapper객체를 이용해서 컬럼의 값을 자동으로dto에 담아줌
		//쿼리메소드는 결과가 여러건이었을때 내부적으로 반복하면서 dto를 생성하고 이 dto를 리스트에 담아줘서 해당 list를 반환해줌
		//roleId와 같은 카멜표기법을 자동으로 db문법인 role_id처럼 BeanPropertyRowMapper가 변환해줌 알아서
	}

}