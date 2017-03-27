package utility;

public enum CommandType {
	PA("Plateu Area", "Command accept. Plateus area defined.", ""),
	RL("Rover Location", "Command accept. Rover location defined.", "You need configure the plateu area first."),
	RD("River Drives", "Command accept. Moving the rover...", "You need configure the plateu area and the rover's location first."),
	CE("Command Error", "", "Command invalid. Please check this.");
	
	private String name;
	private String confirmationMessage;
	private String denialMessage;
	
	public String getConfirmationMessage() {
		return confirmationMessage;
	}
	
	public String getDenialMessage() {
		return denialMessage;
	}
	
	private CommandType(String name, String confirmationMessage, String desialMessage) {
		this.name = name();
		this.confirmationMessage = confirmationMessage;
		this.denialMessage = desialMessage;
	}
}
