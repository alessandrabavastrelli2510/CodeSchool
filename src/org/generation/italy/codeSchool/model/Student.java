package org.generation.italy.codeSchool.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student {
    private int id;
    private static int idGenerator=1;//un solo idGenerator che crea tanti id 
    private String name;
    private String lastname;
    private ArrayList<Exam> transcript;
    private static HashMap<Integer,Student> students=new HashMap();
    //private static final int MAX_AGE=30; //la final non può cambiare valore 

    public Student(String name, String lastname){
        this.id=Student.idGenerator++;
        this.name=name;
        this.lastname=lastname;
        this.transcript=new ArrayList<>();
        students.put(id,this);
    }
    public static void addStudentToCourse(HashMap<Integer,Course> courses,int courseId){
        for(Integer key: courses.keySet()){
            if(key==courseId){
               Course c= courses.get(key);
               students=c.getHashMapStudent();
               Student student=new Student(askStudentName(),askStudentLastname());
               students.put(idGenerator,student);
            }

        } 
            
    }
    public static String askStudentName(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Inserisci il nome dello studente che vuoi inserire");
        String name=scanner.nextLine();
        return name;
    }
    public static String askStudentLastname(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Inserisci il cognome dello studente che vuoi inserire");
        String lastname=scanner.nextLine();
        return lastname;
    }
    // public static Student createStudent(){
    //     Scanner scanner=new Scanner(System.in);
    //     System.out.println("Inserisci il nome dello studente che vuoi inserire");
    //     String name=scanner.nextLine();
    //     System.out.println("Inserisci il cognome dello studente che vuoi inserire");
    //     String lastname=scanner.nextLine();
    //     Student studentToAdd=new Student(name,lastname);
    //     return studentToAdd;
    // }
    public int getStudentIdFromUtent(){
            System.out.println("Inserisci l'id dello studente desiderato");
            Scanner scanner=new Scanner(System.in);
            int StudentIdFromUtent= scanner.nextInt();
            return StudentIdFromUtent;
    }
    
    public int calculateAverage(){
        int courseId=Course.getCourseIdFromUtent();
        int studentId=getStudentIdFromUtent();
        for(Integer key: students.keySet()){
            if(key==id){
               Course c= courses.get(key);
               ArrayList <Student> list=c.getCourseStudentList();
               for(Student s:list){
                System.out.println(s);
               }
            }
        }


    }
    public String getFullName(){
        return name+" "+lastname;
    }

}
