package treasurehuntgame;

public class Treasure {

	private String name;
	private String description;
	private int value;

	public Treasure(String name, String description, int value) {
		this.name = name;
		this.description = description;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
