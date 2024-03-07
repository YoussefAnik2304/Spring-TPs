package com.example.demo2.Filters;

import com.example.demo2.Student;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebFilter("/MyServlet")
public class MyFilter2 extends HttpFilter {
    public MyFilter2() {
        super();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpSession session =request.getSession();
        String DateNaissance= (String) request.getParameter("dateNaissance");
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("filter 2");
        try{
            Date date=dateFormat.parse(DateNaissance);
            SimpleDateFormat years =new SimpleDateFormat("yyyy");
            long year= Long.parseLong(years.format(date));
            if(2024-year<22){
                request.setAttribute("error","not old enough ");
                request.getRequestDispatcher("/").forward(req,res);
                System.out.println("not old enough ");
                return;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        chain.doFilter(req, res);
    }
}
