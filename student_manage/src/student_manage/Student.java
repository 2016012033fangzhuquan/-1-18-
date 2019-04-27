package student_manage;

public class Student {
	private int ID;
	private String name;
	private String birDate;
	private boolean gender;	// 0-girl 1-boy
	
	public void setID(int ID){
		this.ID = ID;
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
		return this.ID;
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
        return "Student " + ID + ": name = " + 
        		name + ", birDate = " + birDate + 
                ", gender" + (gender?"male":"female");
    }

}
