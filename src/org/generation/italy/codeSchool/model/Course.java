package org.generation.italy.codeSchool.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Course {
    private int id;
    private static int idGenerator;
    private String title;
    private Area areaTitle;
    private DifficultyLevel difficultyLevel;
    private static HashMap<Integer,Course> courses=new HashMap();
    private static HashMap<Integer,Student> students;


    public Course(String title, Area areaTitle,DifficultyLevel difficultyLevel){
        this.title=title;
        this.id=Course.idGenerator++;
        this.areaTitle=areaTitle;
        this.difficultyLevel=difficultyLevel;
        this.students=new HashMap<Integer,Student> ();
        courses.put(id,this);
        
    }
    public static void printCourseList(){
        System.out.println("Lista dei corsi:");
        for (Course course : courses.values()) {    //for(Integer id : courses.keySet()) per iterare sulle chiavi 
            System.out.println("ID: " + course.id);
            System.out.println("Titolo: " + course.title);
            System.out.println("Area: " + course.areaTitle);
            System.out.println("Livello di difficoltà: " + course.difficultyLevel);
            System.out.println("------------------------");
        }
    }
     public static void createCourse(){
        Scanner scanner= new Scanner(System.in);
        Course newCourse;
        System.out.println("Inserisci il titolo del corso che vuoi aggiungere");
        String title=scanner.nextLine();
        System.out.println("Inserisci l'area scegliendo tra CODING, IT_OPS, DESIGN");
        Area area=null;
        String stringArea=scanner.nextLine().toUpperCase();
        do {
            for(Area a : Area.values()){
                if(a.name().equals(stringArea)){
                    area=a;
                    break;
                } 
            }
            if (area == null) {
                System.out.println("Area non valida, inserisci un'area corretta");
                stringArea=scanner.nextLine().toUpperCase();
            }
            
        } while (area==null);
        
        System.out.println("Inserisci il livello di difficoltà tra BASIC, INTERMEDIATE, ADVANCED, GURU");
        DifficultyLevel dl=null;
        String diffLev= scanner.nextLine().toUpperCase();
        do {
            for(DifficultyLevel d: DifficultyLevel.values()){
                if(d.name().equals(diffLev)){
                    dl=d;
                    break;
                }
            }
            if(dl == null){
                System.out.println("Livello di difficoltà non valido, inserisci un livello corretto");
                diffLev=scanner.nextLine().toUpperCase();
            }   
        } while (dl==null);
        Course course= new Course(title, area, dl); 
    }
    // public  HashMap<Integer,Course> getCourseStudentList(){
        
    // }
    
    public static int getCourseIdFromUtent(){
        System.out.println("Inserisci l'id del corso desiderato");
        Scanner scanner=new Scanner(System.in);
        int idFromUtent= scanner.nextInt();
        return idFromUtent;
    }
    public static void readStudentList(){
        int id=getCourseIdFromUtent();
        System.out.println("La lista degli studenti si compone di: ");
        for(Integer key: courses.keySet()){
            if(key==id){
               Course c= courses.get(key);
               students=c.getHashMapStudent();
                for (Map.Entry<Integer, Student> entry : students.entrySet()) {
                    System.out.println("id: "+entry.getKey() + ", studente: " + entry.getValue().getFullName());
                }
            }
        }
    }
    public HashMap<Integer,Student> getHashMapStudent(){
        return students;
    }
    public static void main(String[] args) {
        Course.createCourse();
        Course.createCourse();
        Course.printCourseList();
        int idToRegisterStudent=Course.getCourseIdFromUtent();
        Student.addStudentToCourse(courses,idToRegisterStudent);
        Course.readStudentList();
    }
}

