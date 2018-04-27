/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLibrary;

import java.util.Arrays;

/**
 *
 * @author dlozanonavas
 */
public class StudentGrades {
    double Grade_1;
    double Grade_2;
    double Grade_3;
    double FinalGrade;

    String Annotations = "";
    String StudentName;
    
    public void setGrades(double grade1,double grade2, double grade3){
        this.Grade_1 = grade1;
        this.Grade_2 = grade2;
        this.Grade_3 = grade3;
        this.setfinalGrade();
    }
    public double[] getGrades(){
        double[] Grades = {this.Grade_1,this.Grade_2,this.Grade_3,this.getFinalGrade()};
        return Grades;
    } 
    public void setName(String name){
            this.StudentName = name;
    }
    public String getName(){
        return this.StudentName;
    }
    void setfinalGrade(){
        this.FinalGrade = (this.Grade_1*0.2) + (this.Grade_2*0.3) + (this.Grade_3*0.5);
    }
    double getFinalGrade(){
        return this.FinalGrade;
    }
    public void setAnnotations(String annotations){       
        this.Annotations = Annotations + annotations + "\n";
    }
    public String getAnnotations(){
        return this.Annotations;
    }
    public void display(){
        System.out.println("Student name: " + this.getName());
        System.out.println("1st grade: "+ this.getGrades()[0]);
        System.out.println("2nd grade: " + this.getGrades()[1]);
        System.out.println("3rd grade: "+ this.getGrades()[2]);
        System.out.println("Final grade: "+ this.getGrades()[3]);
        if (this.getFinalGrade() <= 60) this.setAnnotations("REPROBADO"); else this.setAnnotations("APROBADO");
        System.out.println("Annotations: "+ this.getAnnotations());
    }
}
