package kr.or.connect.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //트랜잭션때문에 필요
public class DBConfig {
	private String driverClassName = "com.mysql.jdbc.Driver"; //드라이버 클래스네임 필요
    private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8";
    //url주소 필요

    private String username = "root";
    private String password = "qsd1001918";

    @Bean//데이터소스를 이용해서 db접속을 얻어낼것인데, datasource를 생성할수있는 클래스 필요
    //datasource객체 등록해야됨, 그래서 bean등록
    public DataSource dataSource() { //dataSource이게 id로 지정임
    	BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }
}