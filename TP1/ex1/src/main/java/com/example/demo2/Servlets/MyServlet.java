package com.example.demo2.Servlets;

import java.io.*;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo2.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/MyServlet" )
public class MyServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("servlet");
        HttpSession session =request.getSession();
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("nom");
        String cne=request.getParameter("cne");
        String id=request.getParameter("id");
        String dateNaissance=request.getParameter("dateNaissance");

        Student std=new Student(id,nom,prenom,cne,dateNaissance);
        List<Student> students =(List<Student>) session.getAttribute("students");
        if(students==null)
            students=new ArrayList<Student>();
        students.add(std);
        session.setAttribute("students",students);
        System.out.println("registered");
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

}