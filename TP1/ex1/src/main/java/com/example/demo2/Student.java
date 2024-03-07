package com.example.demo2;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String id;
    private String nom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    private String prenom;
    private String cne ;
    private String dateNaissance;

    public Student(String id, String nom, String prenom, String cne, String dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.dateNaissance = dateNaissance;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }
    @Override
    public int compareTo(Student s) {
        return this.id.compareTo(s.id);
    }
}
