package com.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("error")
public class ErrorController {
	@RequestMapping("/404.html")
    public void err404(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.sendRedirect("/404.htm");
    }
 	@RequestMapping("/500.html")
    public void err500(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
 		resp.sendRedirect("/500.htm");
    }
}
