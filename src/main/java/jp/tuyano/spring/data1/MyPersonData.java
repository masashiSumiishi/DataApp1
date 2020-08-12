package jp.tuyano.spring.data1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mypersondata")
public class MyPersonData {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length=50, nullable=false)
	private String name;

	@Column(length=50, nullable=true)
	private String mail;

	@Column(nullable=true)
	private int age;

	public MyPersonData() {
	}

	public MyPersonData(String name, String mail, int age) {
		this();
		this.name = name;
		this.mail = mail;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MyPersonData [id=" + id + ", name=" + name +
				", mail" + mail + ", age=" + age + "]";
	}
}
