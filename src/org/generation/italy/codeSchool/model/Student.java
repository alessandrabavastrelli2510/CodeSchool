package org.generation.italy.codeSchool.model;

import java.util.ArrayList;

public class Student {
    private int id;
    private static int idGenerator=1;//un solo idGenerator che crea tanti id 
    private String name;
    private String lastname;
    private ArrayList<Exam> transcript;
    //private static final int MAX_AGE=30; //la final non può cambiare valore 

    public Student(String name, String lastname){
        this.id=Student.idGenerator++;
        this.name=name;
        this.lastname=lastname;
        this.transcript=new ArrayList<>();
    }
}
