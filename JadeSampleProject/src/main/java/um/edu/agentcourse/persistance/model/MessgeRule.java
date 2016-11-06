package um.edu.agentcourse.persistance.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messge_rule")
public class MessgeRule {
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFromAge() {
		return fromAge;
	}

	public void setFromAge(long fromAge) {
		this.fromAge = fromAge;
	}

	public long getToAge() {
		return toAge;
	}

	public void setToAge(long toAge) {
		this.toAge = toAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="fromAge")
	private long fromAge;
	
	@Column(name="toAge")
	private long toAge;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="message")
	private String message;
	
	

}
