/**
 * @author ShadowGhostH
 * @version 1.2
 * This is a Class for information of students
 * You can use get/set functions to duel with these information
 * We override toString() to output the information
 */


package studentmanage;

public class Student {
	private int id;
	private String name;
	private String birDate;
	private boolean gender;	// 0-girl 1-boy
	
	public void setID(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setBirDate(String birDate){
		this.birDate = birDate;
	}
	public void setGender(boolean gender){
		this.gender = gender;
	}
	
	public int getID(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getBirDate(){
		return this.birDate;
	}
	public boolean getGender(){
		return this.gender;
	}
	
	@Override
    public String toString() {
        return "Student " + id + ": name = " + 
        		name + ", birDate = " + birDate + 
                ", gender = " + (gender?"male":"female");
    }

}
