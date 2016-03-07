package com.test;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
@Controller("test")
@RequestMapping(value="/index",method={RequestMethod.GET,RequestMethod.POST})
public class Test {
	 	@RequestMapping("/index.html")
	    public ModelAndView login(HttpServletRequest req,HttpServletResponse resp){
	 		String uri = req.getRequestURI();
	 		uri = uri.substring(uri.lastIndexOf("/")+1);
	        return new ModelAndView(uri);
	    }
	 	@RequestMapping("/index.asp")
	    public void login2(HttpServletRequest req,HttpServletResponse resp,@RequestBody User user) throws IOException{
	 		System.out.println(JSON.toJSONString(user));
	 		resp.getWriter().println("ssssssssssssssssssss");
	    }
	 	@RequestMapping("/index.asp1")
	 	@ResponseBody
	    public User login5() throws IOException{
	 		
	 		return new User();
	    }
	 	@RequestMapping("/index.jsp")
	    public void login3(HttpServletRequest req,HttpServletResponse resp) throws IOException{
	 		resp.sendRedirect("/index/index.html");
	    }
	 	@RequestMapping("/index.jspx")
	    public void login4(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
	 		req.getRequestDispatcher("/index/index.html").forward(req, resp);
	    }
	 	
}
