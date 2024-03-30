package org.generation.italy.codeSchool.model;

import java.util.HashMap;

public class Course {
    private int id;
    private static int idGenerator;
    private String title;
    private Area areaTitle;
    private DifficultyLevel difficultyLevel;
    private static HashMap<Integer,Course> courses=new HashMap();


    public Course(String title, Area areaTitle,DifficultyLevel difficultyLevel){
        this.title=title;
        this.id=Course.idGenerator++;
        this.areaTitle=areaTitle;
        this.difficultyLevel=difficultyLevel;
        courses.put(id,this);
    }
    public static void printCourseList(){
        System.out.println("Lista dei corsi:");
        for (Course course : courses.values()) {
            System.out.println("ID: " + course.id);
            System.out.println("Titolo: " + course.title);
            System.out.println("Area: " + course.areaTitle);
            System.out.println("Livello di difficoltà: " + course.difficultyLevel);
            System.out.println("------------------------");
        }
    }


}
