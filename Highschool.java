/*****************************************
Zeyad Hany Moustafa ElShafei
120210033
CSE SEC 1

Yara Wael Anwar ElSaid 
120210266
CSE SEC 4
******************************************/
//Packages to use
import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Arrays;

public class Highschool implements optionInterface{
  public String schoolName = "Highschool";
  public String text;
  public String newText;
  public String errorMessage = "";
  
  public JLabel label = new JLabel(this.errorMessage);//This is a replacemenet for them

  int jumpIndex;
  public ArrayList<Department> DepartmentList = new ArrayList<Department>(); 

  public Highschool(String schoolName){
    this.schoolName = schoolName;  
  }
  
  public void addDepartment(String newDepartmentName){
    //Try commenting this and see if it works
    for(int i = 0; i < this.DepartmentList.size(); i++){
      if(this.DepartmentList.get(i).getName().equals(newDepartmentName)){
        System.out.println("This department already exists!");
        return;
      }
    }
    Department newDepartment = new Department(newDepartmentName);
    this.DepartmentList.add(newDepartment);
  }

  public void remove(String newDepartmentName){
    for(int i = 0; i < this.DepartmentList.size(); i++){
      if(DepartmentList.get(i).getName().equals(newDepartmentName)){
        this.DepartmentList.get(i).departmentName = newDepartmentName;
        this.DepartmentList.remove(i);
        this.errorMessage = "Changes made successfully";
        return;
      }
    }
    this.errorMessage = "This department doesn't exist!";
    System.out.println("This department doesn't exist!");
  }

  public void update(String departmentName, String newDepartmentName){
    for(int i = 0; i < this.DepartmentList.size(); i++){
      if(DepartmentList.get(i).getName().equals(newDepartmentName)){
        this.DepartmentList.get(i).departmentName = newDepartmentName;
        this.DepartmentList.get(i).setName(newDepartmentName);
        return;
      }
    }
    System.out.println("This department doesn't exist!");
  }

  public ArrayList<String> display(){
    ArrayList<String> departmentsExist = new ArrayList<String>();
    for(int i = 0; i < this.DepartmentList.size(); i++){
      departmentsExist.add(this.DepartmentList.get(i).getName());
      System.out.println(i + " Department :" + this.DepartmentList.get(i).getName());
    }
    return departmentsExist;
  }
  
  // GUI
  public void window1(){
    // Create a window
    JFrame frame = new JFrame("My Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 2));
    JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
    JPanel labelPanel = new JPanel(new BorderLayout());
    JPanel inputPanel = new JPanel(new GridLayout(2, 1));//Changes where made from BorderLayout()

    // Declaring the buttons
    JButton Add = new JButton("Add new department");
    JButton Remove = new JButton("Remove department");
    JButton Update = new JButton("Update department");
    JButton Display = new JButton("Display all departments");
    JButton GoTo = new JButton("Go to the department options");
    // Add input box and enter button to inputPanel
    JTextField inputBox = new JTextField();
    inputBox.setBorder(BorderFactory.createTitledBorder("Apply to department: "));
    inputPanel.add(inputBox, BorderLayout.CENTER);
    //inputPanel.add(new JButton("Enter"), BorderLayout.EAST);
    //this.text = inputBox.getText();
    inputBox.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
    });

    // Old name input box
    JTextField newName = new JTextField();
    newName.setBorder(BorderFactory.createTitledBorder("New name to apply: "));
    inputPanel.add(newName, BorderLayout.CENTER);
    //this.newText = newName.getText();
    newName.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
    });



    // Adding the functionality to the buttons
    Add.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){ 
        Highschool.this.addDepartment(Highschool.this.text);
      }
    });

    Remove.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.remove(Highschool.this.text);
      }
    });

    Update.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.update(Highschool.this.text, Highschool.this.newText);
      }
    });

    Display.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        ArrayList<String> saveResult = Highschool.this.display();
        System.out.println("This is the array of departments: " + saveResult);
        Highschool.this.errorMessage = "";
        for(int i = 0; i < saveResult.size(); i++){
          Highschool.this.errorMessage += saveResult.get(i) + " \n ";
          Highschool.this.label.setText(Highschool.this.errorMessage);
          System.out.println("This is the ouput here: " + Highschool.this.errorMessage);
        }
      }
    });

    GoTo.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        for(int i = 0; i < Highschool.this.DepartmentList.size(); i++){
          if(Highschool.this.DepartmentList.get(i).getName().equals(Highschool.this.text)){
            Highschool.this.jumpIndex = i; 
            System.out.println("Found this student!");
            Highschool.this.label.setText("Found this student!");
            Highschool.this.window2();
          };
        }
        //Highschool.this.window2();// This line was commented to make sure that that student does exist and to avoid
        //exception errors
        //Remove this line at your own cost
        System.out.println("This student does not exist!");
      }
    });

    // Add buttons to buttonPanel
    buttonPanel.add(Update);
    buttonPanel.add(Add);
    buttonPanel.add(Remove);
    buttonPanel.add(Display);
    buttonPanel.add(GoTo);

    labelPanel.add(Highschool.this.label, BorderLayout.CENTER);

    panel.add(buttonPanel);
    panel.add(labelPanel);
    panel.add(inputPanel);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
  
  public void window2(){
    JFrame frame = new JFrame("My Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel buttonPanel = new JPanel(new GridLayout(5, 1));

    JButton goToStudents1 = new JButton("Go to year 1 students");
    JButton goToStudents2 = new JButton("Go to year 2 students");
    JButton goToStudents3 = new JButton("Go to year 3 students");
  
    JButton goToSubTeachers = new JButton("Go to substitute teachers");
    JButton goToTeachers = new JButton("Go to teachers");
    
    buttonPanel.add(goToTeachers);
    buttonPanel.add(goToSubTeachers);
    buttonPanel.add(goToStudents1);
    buttonPanel.add(goToStudents2);
    buttonPanel.add(goToStudents3);
    
    goToStudents1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        windowStudent1();
      }
    });

    goToStudents2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        windowStudent2();
      }
    });

    goToStudents3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        windowStudent3();
      }
    });

    goToTeachers.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        windowTeachers();
      }
    });
    
    goToSubTeachers.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        windowSubTeachers();
      }
    });
    
    frame.add(buttonPanel);
    frame.pack();
    frame.setVisible(true);
  }

  public void windowStudent1(){
    JFrame frame = new JFrame("My Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 2));
    JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
    JPanel labelPanel = new JPanel(new BorderLayout());
    JPanel inputPanel = new JPanel(new GridLayout(2, 1));//Changes where made from BorderLayout()

    // Declaring the buttons
    JButton displayStudents1 = new JButton("Display all students");
    JButton displayTop1 = new JButton("Display top student");
    
    JButton addStudent = new JButton("Add student");
    JButton updateName = new JButton("Update student name");
    JButton updateGrade = new JButton("Update student grade");

    // Add input box and enter button to inputPanel
    JTextField inputBox = new JTextField();
    inputBox.setBorder(BorderFactory.createTitledBorder("Apply to student: "));
    inputPanel.add(inputBox, BorderLayout.CENTER);
    //inputPanel.add(new JButton("Enter"), BorderLayout.EAST);
    //this.text = inputBox.getText();

    //Event listener for input box and THIS IS A REPLACEMENT FOR THE LAST LINE
    inputBox.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
    });

    // Old name input box
    JTextField newName = new JTextField();
    newName.setBorder(BorderFactory.createTitledBorder("New name/grade to apply: "));
    inputPanel.add(newName, BorderLayout.CENTER);
    //this.newText = newName.getText();

    //Event Listener for input box and THIS IS A REPLACEMENT FOR THE LAST LINE 
    newName.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
    });


    addStudent.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).addStudent1(Highschool.this.text);
      }
    });

    displayStudents1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents1().size(); i++){
          Highschool.this.errorMessage += Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents1().get(i).getName();
          Highschool.this.errorMessage += " \n "; //This is for vertical alignment
          Highschool.this.label.setText(Highschool.this.errorMessage);
        }
      }
    });
    
    displayTop1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = Highschool.this.DepartmentList.get(jumpIndex).getTop1().getName();
        Highschool.this.label.setText(Highschool.this.errorMessage);
      }
    });

    updateName.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < Highschool.this.DepartmentList.get(jumpIndex).displayStudents1().size(); i++){
          if(Highschool.this.text.equals(Highschool.this.DepartmentList.get(jumpIndex).displayStudents1().get(i).getName())){
            Highschool.this.DepartmentList.get(jumpIndex).displayStudents1().get(i).setName(Highschool.this.newText);
            Highschool.this.label.setText("Name updated successfully");
            return;//Remove this line if it causes any trouble
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });

    updateGrade.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = "";
        Double newGrade;
        for(int i = 0; i < Highschool.this.DepartmentList.get(jumpIndex).displayStudents1().size(); i++){
          if(Highschool.this.text.equals(Highschool.this.DepartmentList.get(jumpIndex).displayStudents1().get(i).getName())){//First get the old student
          try{
            newGrade = Double.parseDouble(Highschool.this.newText);
            Highschool.this.DepartmentList.get(jumpIndex).displayStudents1().get(i).setGrade(newGrade);
            Highschool.this.label.setText("Grade updated successfully");
            return;
            }
          catch(NumberFormatException e1){
            System.out.println("Incorrect grade format");
            }
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });

    buttonPanel.add(displayStudents1);
    buttonPanel.add(addStudent);
    buttonPanel.add(displayTop1);
    buttonPanel.add(updateName);
    buttonPanel.add(updateGrade);
    
    labelPanel.add(Highschool.this.label, BorderLayout.CENTER);

    panel.add(buttonPanel);
    panel.add(labelPanel);
    panel.add(inputPanel);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  public void windowStudent2(){
    JFrame frame = new JFrame("My Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 2));
    JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
    JPanel labelPanel = new JPanel(new BorderLayout());
    JPanel inputPanel = new JPanel(new GridLayout(2, 1));//Changes where made from BorderLayout()
    
    // Declaring the buttons
    JButton displayStudents2 = new JButton("Display all students");
    JButton displayTop2 = new JButton("Display top student");
    
    JButton addStudent = new JButton("Add student");
    JButton updateName = new JButton("Update student name");
    JButton updateGrade = new JButton("Update student grade");

    // Add input box and enter button to inputPanel
    JTextField inputBox = new JTextField();
    inputBox.setBorder(BorderFactory.createTitledBorder("Apply to student: "));
    inputPanel.add(inputBox, BorderLayout.CENTER);
    //inputPanel.add(new JButton("Enter"), BorderLayout.EAST);
    //this.text = inputBox.getText();
    inputBox.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
    });

    // Old name input box
    JTextField newName = new JTextField();
    newName.setBorder(BorderFactory.createTitledBorder("New name/grade to apply: "));
    inputPanel.add(newName, BorderLayout.CENTER);
    //this.newText = newName.getText();
    newName.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.newText = newName.getText();
      }
    });


    addStudent.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).addStudent2(Highschool.this.text);
      }
    });

    displayStudents2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < DepartmentList.get(jumpIndex).displayStudents2().size(); i++){
          Highschool.this.errorMessage += Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents2().get(i).getName();
          Highschool.this.errorMessage += " \n "; //This is for vertical alignment
          Highschool.this.label.setText(Highschool.this.errorMessage);
        }
      }
    });
    
    displayTop2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = DepartmentList.get(jumpIndex).getTop2().getName();
        Highschool.this.label.setText(Highschool.this.errorMessage);
      }
    });

    updateName.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents2().size(); i++){
          if(Highschool.this.text.equals(Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents2().get(i).getName())){
            Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents2().get(i).setName(Highschool.this.newText);
            Highschool.this.label.setText("Name updated successfully");
            return;
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });

    updateGrade.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = "";
        Double newGrade;
        for(int i = 0; i < Highschool.this.DepartmentList.get(jumpIndex).displayStudents2().size(); i++){
          if(Highschool.this.text.equals(Highschool.this.DepartmentList.get(jumpIndex).displayStudents2().get(i).getName())){//First get the old student
          try{
            newGrade = Double.parseDouble(Highschool.this.newText);
            DepartmentList.get(Highschool.this.jumpIndex).displayStudents2().get(i).setGrade(newGrade);
            Highschool.this.label.setText("Grade successfully updated");
            }
          catch(NumberFormatException e2){
            System.out.println("Incorrect grade format");
            }
          }
        }
      }
    });
    
    buttonPanel.add(displayStudents2);
    buttonPanel.add(addStudent);
    buttonPanel.add(displayTop2);
    buttonPanel.add(updateName);
    buttonPanel.add(updateGrade);
    
    labelPanel.add(Highschool.this.label, BorderLayout.CENTER);

    panel.add(buttonPanel);
    panel.add(labelPanel);
    panel.add(inputPanel);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  public void windowStudent3(){
    JFrame frame = new JFrame("My Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 2));
    JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
    JPanel labelPanel = new JPanel(new BorderLayout());
    JPanel inputPanel = new JPanel(new GridLayout(2, 1));//Changes where made from BorderLayout()

    // Declaring the buttons
    JButton displayStudents3 = new JButton("Display all students");
    JButton displayTop3 = new JButton("Display top student");
   
    JButton addStudent = new JButton("Add student");
    JButton updateName = new JButton("Update student name");
    JButton updateGrade = new JButton("Update student grade");

    // Add input box and enter button to inputPanel
    JTextField inputBox = new JTextField();
    inputBox.setBorder(BorderFactory.createTitledBorder("Apply to student: "));
    inputPanel.add(inputBox, BorderLayout.CENTER);
    //inputPanel.add(new JButton("Enter"), BorderLayout.EAST);
    //this.text = inputBox.getText();
    inputBox.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
    });

    // Old name input box
    JTextField newName = new JTextField();
    newName.setBorder(BorderFactory.createTitledBorder("New name/grade to apply: "));
    inputPanel.add(newName, BorderLayout.CENTER);
    //this.newText = newName.getText();
    inputBox.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
    });


    addStudent.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).addStudent3(Highschool.this.text);
      }
    });

    displayStudents3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < Highschool.this.DepartmentList.get(jumpIndex).displayStudents3().size(); i++){
          Highschool.this.errorMessage += Highschool.this.DepartmentList.get(jumpIndex).displayStudents3().get(i).getName();
          Highschool.this.errorMessage += " \n "; //This is for vertical alignment
          Highschool.this.label.setText(Highschool.this.errorMessage);
        }
      }
    });
    
    displayTop3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = Highschool.this.DepartmentList.get(jumpIndex).getTop3().getName();
        Highschool.this.label.setText(Highschool.this.errorMessage);
      }
    });

    updateName.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents3().size(); i++){
          if(Highschool.this.text.equals(Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents3().get(i).getName())){
            Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents3().get(i).setName(Highschool.this.newText);
            Highschool.this.label.setText("Name updated successfully");
            return;
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });

    updateGrade.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = "";
        Double newGrade;
        for(int i = 0; i < Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents3().size(); i++){
          if(Highschool.this.text.equals(Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayStudents3().get(i).getName())){//First get the old student
          try{
            newGrade = Double.parseDouble(Highschool.this.newText);
            Highschool.this.DepartmentList.get(jumpIndex).displayStudents3().get(i).setGrade(newGrade);
            Highschool.this.label.setText("Grade updated successfully");
            return;
            }
          catch(NumberFormatException e2){
            System.out.println("Incorrect grade format");
            }
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });
    
    buttonPanel.add(displayStudents3);
    buttonPanel.add(addStudent);
    buttonPanel.add(displayTop3);
    buttonPanel.add(updateName);
    buttonPanel.add(updateGrade);
    
    labelPanel.add(Highschool.this.label, BorderLayout.CENTER);

    panel.add(buttonPanel);
    panel.add(labelPanel);
    panel.add(inputPanel);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
  
  public void windowTeachers(){
    JFrame frame = new JFrame("My Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 2));
    JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
    JPanel labelPanel = new JPanel(new BorderLayout());
    JPanel inputPanel = new JPanel(new GridLayout(2, 1));//Changes where made from BorderLayout()

    // Declaring the buttons
    JButton addTeacher = new JButton("Add new teacher");
    JButton displayTeachers = new JButton("Display all teachers");
    JButton displayHead = new JButton("Display Head");
    
    JButton updateName = new JButton("Update teacher name");
    JButton updateSalary = new JButton("Update teacher salary");

    // Add input box and enter button to inputPanel
    JTextField inputBox = new JTextField();
    inputBox.setBorder(BorderFactory.createTitledBorder("Apply to teacher: "));
    inputPanel.add(inputBox, BorderLayout.CENTER);
    //inputPanel.add(new JButton("Enter"), BorderLayout.EAST);
    //this.text = inputBox.getText();
    inputBox.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
    });


    // Old name input box
    JTextField newName = new JTextField();
    newName.setBorder(BorderFactory.createTitledBorder("New name/salary to apply: "));
    inputPanel.add(newName, BorderLayout.CENTER);
    //this.newText = newName.getText();
    newName.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = newName.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = newName.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = newName.getText();
      }
    });

    
    addTeacher.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).addTeacher(Highschool.this.text);
      }
    });

    displayTeachers.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < DepartmentList.get(Highschool.this.jumpIndex).displayTeachers().size(); i++){
          Highschool.this.errorMessage += Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayTeachers().get(i).getName();
          Highschool.this.errorMessage += " \n "; //This is for vertical alignment
          Highschool.this.label.setText(Highschool.this.errorMessage);
        }
      }
    });
    
    displayHead.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = DepartmentList.get(jumpIndex).getHead().getName();
        Highschool.this.label.setText(Highschool.this.errorMessage);
      }
    });

    updateName.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayTeachers().size(); i++){
          if(Highschool.this.text.equals(Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayTeachers().get(i).getName())){
            Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayTeachers().get(i).setName(Highschool.this.newText);
            Highschool.this.label.setText("Name updated successfully");
            return;
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });

    updateSalary.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = "";
        Double newSalary;
        for(int i = 0; i < DepartmentList.get(Highschool.this.jumpIndex).displayTeachers().size(); i++){
          if(Highschool.this.text.equals(DepartmentList.get(Highschool.this.jumpIndex).displayTeachers().get(i).getName())){//First get the old student
          try{
            newSalary = Double.parseDouble(Highschool.this.newText);
            Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displayTeachers().get(i).setSalary(newSalary);
            Highschool.this.label.setText("Salary updated successfully");
            return;
            }
          catch(NumberFormatException e2){
            System.out.println("Incorrect salary format");
            }
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });

    buttonPanel.add(displayTeachers);
    buttonPanel.add(addTeacher);
    buttonPanel.add(displayHead);
    buttonPanel.add(updateName);
    buttonPanel.add(updateSalary);
    
    labelPanel.add(Highschool.this.label, BorderLayout.CENTER);

    panel.add(buttonPanel);
    panel.add(labelPanel);
    panel.add(inputPanel);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  public void windowSubTeachers(){
    JFrame frame = new JFrame("My Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 2));
    JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
    JPanel labelPanel = new JPanel(new BorderLayout());
    JPanel inputPanel = new JPanel(new GridLayout(2, 1));//Changes where made from BorderLayout()

    // Declaring the buttons
    JButton displaySubTeachers = new JButton("Display all substitute teachers");
    //This part is for adding
    JButton addSubTeacher = new JButton("Add substitute teacher");

    JButton updateName = new JButton("Update substitute teacher name");
    JButton updateSalary = new JButton("Update substitute teacher salary");

    // Add input box and enter button to inputPanel
    JTextField inputBox = new JTextField();
    inputBox.setBorder(BorderFactory.createTitledBorder("Apply to substitute teacher: "));
    inputPanel.add(inputBox, BorderLayout.CENTER);
    //inputPanel.add(new JButton("Enter"), BorderLayout.EAST);
    this.text = inputBox.getText();
    inputBox.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = inputBox.getText();
      }
    });

    // Old name input box
    JTextField newName = new JTextField();
    newName.setBorder(BorderFactory.createTitledBorder("New name/salary to apply: "));
    inputPanel.add(newName, BorderLayout.CENTER);
    this.newText = newName.getText();
    newName.getDocument().addDocumentListener(new DocumentListener(){
      public void changedUpdate(DocumentEvent e) {
        Highschool.this.text = newName.getText();
      }
      public void removeUpdate(DocumentEvent e) {
        Highschool.this.text = newName.getText();
      }
      public void insertUpdate(DocumentEvent e) {
        Highschool.this.text = newName.getText();
      }
    });

   
    //This part is for adding
    addSubTeacher.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).addStudent1(Highschool.this.text);
      }
    });

    displaySubTeachers.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < Highschool.this.DepartmentList.get(jumpIndex).displaySubTeachers().size(); i++){
          Highschool.this.errorMessage += Highschool.this.DepartmentList.get(jumpIndex).displaySubTeachers().get(i).getName();
          Highschool.this.errorMessage += " \n "; //This is for vertical alignment
          Highschool.this.label.setText(Highschool.this.errorMessage);
        }
      }
    });
    
    updateName.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      Highschool.this.errorMessage = "";
        for(int i = 0; i < Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displaySubTeachers().size(); i++){
          if(Highschool.this.text.equals(Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displaySubTeachers().get(i).getName())){
            Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displaySubTeachers().get(i).setName(Highschool.this.newText);
            Highschool.this.label.setText("Name updated successfully");
            return;
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });

    updateSalary.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Highschool.this.errorMessage = "";
        Double newSalary;
        for(int i = 0; i < Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displaySubTeachers().size(); i++){
          if(Highschool.this.text.equals(DepartmentList.get(Highschool.this.jumpIndex).displaySubTeachers().get(i).getName())){//First get the old student
          try{
            newSalary = Double.parseDouble(Highschool.this.newText);
            Highschool.this.DepartmentList.get(Highschool.this.jumpIndex).displaySubTeachers().get(i).setSalary(newSalary);
            Highschool.this.label.setText("Salary updated successfully");
            return;
            }
          catch(NumberFormatException e2){
            System.out.println("Incorrect salary format");
            }
          }
        }
        Highschool.this.label.setText("Student doesn't exist");
      }
    });
    
    buttonPanel.add(addSubTeacher);
    buttonPanel.add(displaySubTeachers);
    buttonPanel.add(updateName);
    buttonPanel.add(updateSalary);
    
    labelPanel.add(Highschool.this.label, BorderLayout.CENTER);

    panel.add(buttonPanel);
    panel.add(labelPanel);
    panel.add(inputPanel);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);

    
  }

  public static void main(String args[]){
    //Test and intialize everything here
    //TEST 
    //Highschool testSchool = new Highschool("Test School");
    //testSchool.addDepartment("Hello mate");
    //testSchool.addDepartment("Hello again");
    //testSchool.display();
    //
    //
    //GUI
    Highschool ourSchool = new Highschool("Lanugages Senior School");
    ourSchool.window1();

  }
}
