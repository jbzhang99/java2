package com.rfchina.community.openapi.entity;

import java.io.Serializable;

public class ExtRoom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String loudong;
	
	private String floor;
	
	private String room;

	public String getLoudong() {
		return loudong;
	}

	public void setLoudong(String loudong) {
		this.loudong = loudong;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
}
