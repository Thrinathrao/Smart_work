package com.techouts.csvworker.model;

import org.springframework.beans.factory.annotation.Value;

public class Developer {

	private String devName;

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	@Override
	public String toString() {
		return "Developer [devName=" + devName + "]";
	}
	
	
}
