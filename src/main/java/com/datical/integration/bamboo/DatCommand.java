package com.datical.integration.bamboo;

public class DatCommand {

	private String command;
	private String description;

	public DatCommand(String command, String description) {
		this.command = command;
		this.description = description;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
