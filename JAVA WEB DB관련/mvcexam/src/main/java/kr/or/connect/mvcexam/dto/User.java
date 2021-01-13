package kr.or.connect.mvcexam.dto;

public class User {
	//userForm에서 받아들이는 input값들을 갖고오려고함
	//spring이 자동으로 채워주는거니까 input에 있는 name과 여기에 있는 name이 같아야됨
	//그리고 private이고 spring이 직접 접근 해주는거니까 이용할수있도록 get set 메소드 꼭해줘야됨
	private String name; 
	private String email;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + "]";
	}	
}