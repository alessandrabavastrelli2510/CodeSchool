package org.generation.italy.codeSchool.model;

import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    private HashMap<Integer,Student> students=new HashMap<>();
    private HashMap<Integer,Course> courses=new HashMap<>();
    Scanner scanner=new Scanner(System.in);
    public int doMenu(){
        printMenu();
        int choice=scanner.nextInt();
        scanner.nextLine();
        do {
            switch (choice) {
                case 1: 
                Course.printCourseList();
                    break;
                case 2:
                Course.createCourse();
                    break;
                case 3:
                Course.readStudentList();
                    break;
                case 4:
                int idToRegisterStudent=Course.getCourseIdFromUtent();
                Student.addStudentToCourse(courses,idToRegisterStudent);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                //richiedi menu
                    break;
            }       
        } while (choice!=-1);
        scanner.close();
        return choice;
    }
    private void printMenu(){
        System.out.println("""
            Inserisci 1 per ricevere la lista di tutti i corsi attualmente gestiti dalla scuola; 
            Inserisci 2 per creare un corso e aggiungerlo alla lista;
            Inserisci 3 per vedere gli studenti iscritti ad un corso in base all'id "
            Inserisci 4 per iscrivere un nuovo studente ad un corso in base all'id "
            Inserisci 5 per ricevere la media dei voti di uno studente in un corso in base all'id utente e id corso;
            Inserisci -1 per uscire;

                """);
    }
    
    
}