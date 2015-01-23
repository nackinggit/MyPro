package entity;

public class Medicine {
	private Integer id;
	private String name;
	private String function;
	
	public Medicine() {
		super();
	}
	
	public Medicine(Integer id, String name, String function) {
		super();
		
		this.setId(id);
		this.setFunction(function);
		this.setName(name);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	
}	
