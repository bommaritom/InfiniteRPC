package main;

import java.util.ArrayList;
import java.util.Arrays;

import util.InputScanner;

public class Main {

	static int numObjects = 3;
	static int subObjects = (numObjects-1)/2;
	
	public static ArrayList<Object> objects;
	
	public static void main(String[] args){
		initiateObjects();
	}
	
	public static class Object{
		
		public String name;
		public ArrayList<Object> beats = new ArrayList<Object>();
		
		public Object(String name){
			this.name = name;
		}
		
		public void assignBeats(String objectName){
			assignBeats(new Object(objectName));
		}
		
		public void assignBeats(Object object){
			beats.add(object);
		}
		
		public boolean beats(Object object){
			return (Arrays.asList(beats).contains(object));
		}
	}
	
	public static void initiateObjects(){
		objects = new ArrayList<Object>();
		String input;
		Object object;
		
		//the first object is named manually by the user
		
		System.out.println("First object: ");
		input = InputScanner.getString();
		object = new Object(input);
		objects.add(object);
		System.out.println("First object: " + object.name);
		
		int i = 0;
		while (i < numObjects){
			Object iObject = objects.get(i);
			int j = 0;
			while (j < subObjects){
				System.out.println( objects.get(i).name + " beats:");
				input = InputScanner.getString();
				Object jObject = new Object(input);
				
				//create a new object if necessary
				if (!isAnObject(input)) objects.add(jObject);
				
				//test if beaten by object
				if (jObject.beats(iObject)){
					System.out.println("You can't do that!");
				} else if (!jObject.beats(iObject)){
					iObject.assignBeats(jObject);
					System.out.println(iObject.name + " beats " + jObject.name);
					j++;
				}
			}
			i++;
		}
	}
	
	public static boolean isAnObject(String name){
		
		for (int i = 0; i < objects.size(); i++){
			if (objects.get(i).name == name){
				return true;
			}
		}
		return false;
	}
	
	
}
