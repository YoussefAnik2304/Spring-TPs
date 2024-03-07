<%@ page import="com.example.demo2.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>List of Students</h1>
<p style="color: red">${error}</p>
<%
        List<Student> students = (List<Student>) request.getSession().getAttribute("students");
        if (students == null || students.isEmpty()) {
            out.println("<p>No students</p>");
        } else {
            out.println("<ul>");
            for (Student student : students) {
                out.println("<li>" + student.getId() + ": " + student.getNom() + " " + student.getPrenom() + " " + student.getDateNaissance() + "</li>");
            }
            out.println("</ul>");
        }

%>

</body>
</html>