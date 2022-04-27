package test1;

public class Toy {
	private String name;

	public Toy(String name) {
		super(); // ?? 필요는없는 부분  
		this.name = name;
	}

	@Override
	public String toString() {
		return "Toy [name=" + name + "]";
	}

}