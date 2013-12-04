package ro.zerotohero.model;

public class RoleEntity {
	private String Name;
	private String Index;

	public RoleEntity(){}
	
	public RoleEntity(String Name, String Index){
		this.Name = Name;
		this.Index = Index;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIndex() {
		return Index;
	}

	public void setIndex(String index) {
		Index = index;
	}

}
