public abstract class abstractStudent{
  public String name;
  public double grade = 0;
  
  public abstractStudent(String name){
    this.name = name;
  }

  public void setName(String newName){
    this.name = newName;
  }

  public String getName(){
    return this.name;
  }

  public void setGrade(double newGrade){
    this.grade = newGrade;
  }

  public double getGrade(){
    return this.grade;
  }
}
