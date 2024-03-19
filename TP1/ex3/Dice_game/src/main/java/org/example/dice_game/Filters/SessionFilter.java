package org.example.dice_game.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(filterName = "sessionFilter",urlPatterns = "/back/*")
public class SessionFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) res;
        HttpSession session =request.getSession();
        if(session.getAttribute("logedInPlayer")==null){
            System.out.println("not loged in ");
            request.getRequestDispatcher("LoginForm.jsp").forward(req,res);
            return ;
        }
        else{
            chain.doFilter(req,res);
        }
    }
}
