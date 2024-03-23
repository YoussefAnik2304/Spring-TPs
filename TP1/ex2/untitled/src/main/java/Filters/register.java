package Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;
@WebFilter("/register")
public class register extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req,res);
        //req.getRequestDispatcher("/WEB-INF/view/register.jsp")
    }
}
