package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController{
	@RequestMapping("/index")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message","Hello SpringMVC");
		return mav;
	}
	
	@RequestMapping("/jump")
	public ModelAndView jump(){
		ModelAndView mav = new ModelAndView("redirect:/index");
		return mav;
	}
	@RequestMapping("/count")
	public ModelAndView count(HttpSession session){
		Integer count = (Integer) session.getAttribute("count");
		if(null==count){
			count = 0;
		}
		count+=1;
		session.setAttribute("count", count);
		ModelAndView mav = new ModelAndView("check");
		return mav;
	}
	@RequestMapping("/clear")
	public ModelAndView check(HttpSession session){
		session.setAttribute("count", 0);
		ModelAndView mav = new ModelAndView("redirect:/count");
		return mav;
	}
}

