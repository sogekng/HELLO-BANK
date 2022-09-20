package com.hellobank.hellobank.services.autentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.hellobank.hellobank.services.CookieService;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      
        try{
            if(CookieService.getCookie(request, "nome") != null){
                return true;
            }
        }
        catch(Exception erro) {}
        
        response.sendRedirect("/login");
        return false;   
    }
}

