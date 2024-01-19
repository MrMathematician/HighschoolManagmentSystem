import java.util.ArrayList;
import java.util.Arrays;

public class Department{
  public String departmentName = "NULL";
  public ArrayList<Teacher> TeacherList = new ArrayList<Teacher>();
  public ArrayList<subTeacher> subTeacherList = new ArrayList<subTeacher>();
  public ArrayList<studentYear1> studentYear1List = new ArrayList<studentYear1>();
  public ArrayList<studentYear2> studentYear2List = new ArrayList<studentYear2>();
  public ArrayList<studentYear3> studentYear3List = new ArrayList<studentYear3>();
  
  public Top1 top1;
  public Top2 top2;
  public Top3 top3;

  public Head headOfDep;
  
  public Department(String departmentName){
    this.departmentName = departmentName; 
  }

  public void setName(String newName){
    this.departmentName = newName;
  }

  public String getName(){
    return this.departmentName;
  }
  
  public void setHead(Head newHead){
    this.headOfDep = newHead; 
  }

  public Head getHead(){
    return this.headOfDep;
  }

  public void setTop1(){
    double grade = 0;
    for(int i = 0; i < studentYear1List.size(); i++){
      if(grade > studentYear1List.get(i).getGrade()){
        this.top1.setName(studentYear1List.get(i).getName());
        this.top1.setGrade(studentYear1List.get(i).getGrade());
      }
    }
  }

  public void setTop2(Top2 newTop2){
    double grade = 0;
    for(int i = 0; i < studentYear2List.size(); i++){
      if(grade > studentYear2List.get(i).getGrade()){
        this.top2.setName(studentYear2List.get(i).getName());
        this.top2.setGrade(studentYear2List.get(i).getGrade());
      }
    }
  }

  public void setTop3(Top3 newTop3){
    double grade = 0;
    for(int i = 0; i < studentYear3List.size(); i++){
      if(grade > studentYear3List.get(i).getGrade()){
        this.top3.setName(studentYear3List.get(i).getName());
        this.top3.setGrade(studentYear3List.get(i).getGrade());
      }
    }
  }

  public Top1 getTop1(){
    return this.top1;
  }

  public Top2 getTop2(){
    return this.top2;
  }

  public Top3 getTop3(){
    return this.top3;

  }
  public void removeStudent1(String studentName){
    for(int i = 0; i < this.studentYear1List.size(); i++){
      if(this.studentYear1List.get(i).getName().equals(studentName)){
        this.studentYear1List.remove(i);
        return;
      }
    }
    System.out.println("This student doesn't exist! ");
  }

  public void removeStudent2(String studentName){
    for(int i = 0; i < this.studentYear2List.size(); i++){
      if(this.studentYear2List.get(i).getName().equals(studentName)){
        this.studentYear2List.remove(i);
        return;
      }
    }
    System.out.println("This student doesn't exist! ");
  }

  public void removeStudent3(String studentName){    
    for(int i = 0; i < this.studentYear3List.size(); i++){
      if(this.studentYear3List.get(i).getName().equals(studentName)){
        this.studentYear3List.remove(i);
        return;
      }
    }
    System.out.println("This student doesn't exist! ");
  }

  public void removeTeacher(String teacherName){
    for(int i = 0; i < this.TeacherList.size(); i++){
      if(this.TeacherList.get(i).getName().equals(teacherName)){
        this.TeacherList.remove(i);
        return;
      }
    }
    System.out.println("This teacher doesn't exist! ");
  }
  
  public void removeSubTeacher(String teacherName){
    for(int i = 0; i < this.subTeacherList.size(); i++){
      if(this.subTeacherList.get(i).getName().equals(teacherName)){
        this.subTeacherList.remove(i);
        return;
      }
    }
    System.out.println("This substitute teacher doesn't exist! ");
  }

  public void addStudent1(String student){
    studentYear1 newStudent = new studentYear1(student);
    this.studentYear1List.add(newStudent);
  }
  
  public void addStudent2(String student){
    studentYear2 newStudent = new studentYear2(student);
    this.studentYear2List.add(newStudent);
  }
  
  public void addStudent3(String student){
    studentYear3 newStudent = new studentYear3(student);
    this.studentYear3List.add(newStudent);
  }

  public void addTeacher(String teacher){
    Teacher newTeacher = new Teacher(teacher);
    this.TeacherList.add(newTeacher);
  }

  public void addSubTeacher(String substituteTeacher){
    subTeacher newSubTeacher = new subTeacher(substituteTeacher);
    this.subTeacherList.add(newSubTeacher);
  }

  public ArrayList<Teacher> displayTeachers(){
    return TeacherList;
  }

  public ArrayList<subTeacher> displaySubTeachers(){
    return subTeacherList;
  }

  public ArrayList<studentYear1> displayStudents1(){
    return studentYear1List;
  }

  public ArrayList<studentYear2> displayStudents2(){
    return studentYear2List;
  }

  public ArrayList<studentYear3> displayStudents3(){
    return studentYear3List;
  }
}
