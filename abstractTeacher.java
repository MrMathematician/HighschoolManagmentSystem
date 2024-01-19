public abstract class abstractTeacher{
  public String name;
  public double salary = 0;
  
  public abstractTeacher(String name){
    this.name = name;
  }

  public void setName(String newName){
    this.name = newName;
  }

  public String getName(){
    return this.name;
  }

  public void setSalary(double newSalary){
    this.salary = newSalary;
  }

  public double getSalary(){
    return this.salary;
  }
}
