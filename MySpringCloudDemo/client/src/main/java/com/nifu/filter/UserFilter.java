package com.nifu.filter;

import com.nifu.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = {"/index.html"},filterName = "userFilter")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpSession session=request.getSession();
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        User user= (User) session.getAttribute("user");
        if(user==null){
            response.sendRedirect("login.html");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
     }

    @Override
    public void destroy() {

    }
}