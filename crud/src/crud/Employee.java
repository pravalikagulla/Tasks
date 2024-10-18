package crud;

import java.util.List;

public class Employee {
	private int id;
	private String name;
	private List<String> cities;
	
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	
public Employee(int id, String name, List<String> cities) {
		super();
		this.id = id;
		this.name = name;
		this.cities = cities;
	}
public String toString() {
	return id+","+name+","+cities;
}

}
