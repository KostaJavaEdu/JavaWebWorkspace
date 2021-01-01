package ex1125.domain;

public class MemberDTO {
	private String id;
	private String name;
	private int age;
	private String addr;
	
	public MemberDTO() {}
	public MemberDTO(String id, String name, int age, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddr() {
		return addr;
	}
}
