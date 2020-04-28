package udemy.json.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UdemyStudent {

	
	private long id;
	private String name;
	private String lastname;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "UdemyStudent [id=" + id + ", name=" + name + ", lastname=" + lastname + "]";
	}

}
