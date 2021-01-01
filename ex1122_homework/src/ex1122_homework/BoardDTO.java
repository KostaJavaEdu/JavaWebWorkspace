package ex1122_homework;

import java.util.Date;

public class BoardDTO {
	//subject, name, date
	private String subject;
	private String name;
	private Date date;
	
	public BoardDTO(String subject, String name, Date date) {
		super();
		this.subject = subject;
		this.name = name;
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
