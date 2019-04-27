package student_manage;
import java.io.*;
import java.util.*;

public class StudentManager {
	final public int maxx = 25;  //the max number of students
	private int cnt = 0;
	public Student[] students = new Student[maxx];
	String fileName = "Students.txt";
	
	StudentManager(){
		for(int i=0; i<maxx; i++) {
			students[i] = new Student();
		}
	}
	
	public int getCnt(){
		return this.cnt;
	}
	
	public void sortStudent(){
		Arrays.sort(students, 0, cnt, new cmp());
	}
	
	public void insert(Student newStudent){
		students[cnt++] = newStudent;
		sortStudent();
		try {
			output();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int delete(String searchName){
		int index = search(searchName);
		if(index == -1)	return index;
		for(int i=index; i<cnt; i++){
			students[i] = students[i+1];
		}
		cnt--;
		try {
			output();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return index;
	}
	
	public int search(String searchName){
		int index = -1;
		for(int i=0; i<cnt; i++){
			if(searchName.equals(students[i].getName())){
				index = i;
				break;
			}
		}
		if(index == -1) System.out.println("Not found");
		System.out.println("search index: " + index);
		return index;
	}
	
	public void revise(String searchName, Student newStudent){
		int index = search(searchName);
		if(index != -1) students[index] = newStudent;
		try {
			output();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void read(){
		File file = new File(fileName);
		BufferedReader reader = null;
		String temp;
		cnt = 0;
		try{
			reader = new BufferedReader(new FileReader(file));
			while((temp = reader.readLine()) != null){
				String[] info = temp.split(" ");
				int newID = Integer.valueOf(info[0]).intValue();
				students[cnt] = new Student();
				this.students[cnt].setID(newID);
				this.students[cnt].setName(info[1]);
				this.students[cnt].setBirDate(info[2]);
				this.students[cnt].setGender(info[3].equals("ÄĞ") ? true : false);
				cnt++;
			}
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void output() throws IOException{
		sortStudent();
        FileOutputStream fs = new FileOutputStream(new File(fileName));
        PrintStream p = new PrintStream(fs);
        for(int i=0; i<cnt; i++)
            p.println(students[i].getID() + " " + students[i].getName() + " " + 
            		students[i].getBirDate() + " " + (students[i].getGender() == true?"ÄĞ":"Å®"));
        p.close();
    }
}

class cmp implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getID() - o2.getID();
	}
	
}

