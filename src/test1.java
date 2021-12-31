import java.util.Scanner;

class Person {
    String name;
    String id;

    public Person(String name){
        this.name = name;
        id = "1";
    }

   public void printName(){
       System.out.println(name);
   }
}

class Student extends Person {
    String grade;
    String department;

    public Student(String name){
        super(name);
        grade = "A";
    }

    public void printGrade(){
        System.out.println(grade);
    }
}

public class test1 {
    public static void main(String[] args) {
        Person student = new Student("이재문");
        //student.getId();
        student.printName();
    }
}
