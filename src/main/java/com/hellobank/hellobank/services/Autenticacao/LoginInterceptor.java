//package com.hellobank.hellobank.services.Autenticacao;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import com.hellobank.hellobank.services.CookieService;
//
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//   @Override
//   public boolean preHandle
//      (HttpServletRequest request, HttpServletResponse response, Object handler) 
//      throws Exception {
//      
//      try{
//         if(CookieService.getCookie(request, "id_cliente") != null){
//            return true;
//         }
//      }
//      catch(Exception erro) {}
//      
//      response.sendRedirect("/login");
//      return false;
//   }
//}