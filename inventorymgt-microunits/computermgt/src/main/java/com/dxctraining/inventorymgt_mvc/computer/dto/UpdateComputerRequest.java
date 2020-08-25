package com.dxctraining.inventorymgt_mvc.computer.dto;

public class UpdateComputerRequest {

	private int diskSize;
	private String name;
	
	private int id;
	
	
	
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

	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}

	

}
