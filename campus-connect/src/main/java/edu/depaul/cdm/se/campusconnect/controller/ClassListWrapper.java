package edu.depaul.cdm.se.campusconnect.controller;

import java.util.ArrayList;
import java.util.List;

import edu.depaul.cdm.se.campusconnect.classpackage.jpa.Class;

public class ClassListWrapper {

	private List <Class> classList = new ArrayList <Class>();
	
	
	public List <Class> getClassList() {
		return classList;
	}
	
	public void setClassList(List <Class> classList) {
		this.classList = classList;
	}
	
	public void addToClassList(Class c) {
		classList.add(c);
	}
	
	//adds to classList and returns the class that was added
	public Class addToClassListAndReturn(Class c) {
		classList.add(c);
		
		return c;
	}
	 
	
	public void removeFromClassList(Class c) {
		classList.remove(c);
	}
	
	//removes class and returns it
	public Class removeFromClassListAndReturn(Class c) {
		classList.remove(c);
		
		return c;
	}
	
	public void getClass(Class c) {
		classList.get(classList.indexOf(c));
	}
	
}
