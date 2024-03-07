package com.example.demo2.Filters;

import com.example.demo2.Student;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebFilter("/MyServlet")
public class MyFilter1 extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpSession session =request.getSession();
        String cne= (String) request.getParameter("cne");
        List<Student> students= (List<Student>) session.getAttribute("students");
        System.out.println("filter 1 ");
        if(students!=null && !students.isEmpty()) {
            for (Student std : students) {
                System.out.println("cne : "+cne);
                if (std.getCne().trim().equalsIgnoreCase(cne.trim())) {
                    System.out.println("already exists ");

                    System.out.println();
                    request.getRequestDispatcher("/").forward(req,res);

                    return;
                }
            }
        }
        System.out.println("filter 3");
        chain.doFilter(req, res);
    }
}
