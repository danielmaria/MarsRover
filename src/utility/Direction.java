package utility;

public enum Direction {
	N("North", "^"),
	S("South", "v"),
	W("West", "<"),
	E("East", ">");
	
	private String direction;
	private String view;
	
	Direction(String direction, String view){
		this.direction = direction;
		this.view = view;
	}
	
	public String getDirection() {
		return direction;
	}

	public String getView() {
		return view;
	}
}
