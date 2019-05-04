/**
 * @author ShadowGhostH
 * @version 1.2
 * This is a Class to manage informations of students
 * 
 */


package student_manage;
import java.io.*;
import java.util.*;

public class StudentManager {
	// the max number of students  final
	final private int maxx = 25; 
	private int cnt = 0;
	public Student[] students = new Student[maxx];
	String fileName = "Students.txt";
	
	StudentManager(){
		/** create every member of students */
		for(int i=0; i<maxx; i++) {
			students[i] = new Student();
		}
	}
	
	public int getCnt(){
		return this.cnt;
	}
	
	
	public void sortStudent(){
		/** sort every member in students by id ascending */
		Arrays.sort(students, 0, cnt, new cmp());
	}
	
	public void insert(Student newStudent){
		/** 
		 * insert a new student to students, after that sort it
		 * with this function count will plus one 
		*/
		if(newStudent.equals(null)) return ;
		students[cnt++] = newStudent;
		sortStudent();
		try {
			output();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int delete(String searchName){
		/**
		 * this function will delete a student by his name
		 * return -1 if we cannot find this student
		 * if delete successfully the cnt--
		 */
		if(searchName.equals(null)) return -1;
		int index = search(searchName);
		if(-1 == index)	return -1;
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
		/**
		 * this function find a student by name
		 * if we find it return the index of he in students
		 * if we don't, return -1
		 */
		if(searchName.equals(null)) return -1;
		int index = -1;
		for(int i=0; i<cnt; i++){
			if(searchName.equals(students[i].getName())){
				index = i;
				break;
			}
		}
		if(-1 == index) System.out.println("Not found");
		else System.out.println("search index: " + index);
		return index;
	}
	
	public void revise(String searchName, Student newStudent){
		/**
		 * this function update the information of student named "searchName" 
		 */
		if(searchName.equals(null) || newStudent.equals(null)) return ;
		int index = search(searchName);
		if(-1 != index) students[index] = newStudent;
		else return ;
		try {
			output();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void read(){
		/**
		 * this function read the file named "fileName" to input the information of students
		 * we can use this function to get the information in other class
		 */
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
				this.students[cnt].setGender(info[3].equals("ÄÐ") ? true : false);
				cnt++;
			}
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void output() throws IOException{
		/**
		 * this function output the information of students to the file named "fileName"
		 * sort with students' id
		 */
		sortStudent();
        FileOutputStream fs = new FileOutputStream(new File(fileName));
        PrintStream p = new PrintStream(fs);
        for(int i=0; i<cnt; i++)
            p.println(students[i].getID() + " " + students[i].getName() + " " + 
            		students[i].getBirDate() + " " + (students[i].getGender() == true?"ÄÐ":"Å®"));
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

