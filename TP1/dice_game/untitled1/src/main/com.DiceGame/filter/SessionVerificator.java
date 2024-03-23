package filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Player;
/*
import java.io.IOException;

@WebFilter("/*")
public class SessionVerificator implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        if ("/DiceGame/login".equals(requestURI) || "/DiceGame/signIn".equals(requestURI) || "/DiceGame/".equals(requestURI)) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = httpRequest.getSession();
            Player currentPlayer = (Player) session.getAttribute("currentPlayer");

            if(currentPlayer != null){
                chain.doFilter(request, response);
            }else{
                httpResponse.sendRedirect("/DiceGame/login");
            }
        }
    }
}
*/