package cs321.ap05.main.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import cs321.ap05.main.services.CommitteeService;

@Controller
public class CommitteeServiceController {

	@Autowired
	CommitteeService commService;
	
	@GetMapping("/home")
	public ModelAndView base(HttpServletRequest request, HttpServletResponse res)
	{
		res.setContentType("text/html");
		ModelAndView mav = new ModelAndView("Base");
		
		return mav;
	}
	
	@GetMapping("/ajax/committee/list")
	public ModelAndView ajaxCommList(HttpServletRequest request, HttpServletResponse res)
	{
		res.setContentType("text/html");
		
		ModelAndView mav = new ModelAndView("ajax_committeeTable");
		
		mav.addObject("comms", commService.listCommittees());
		
		return mav;
	}
	
	@GetMapping("/ajax/committee/add")
	public ModelAndView ajaxCommAdd(HttpServletRequest request, HttpServletResponse res)
	{
		res.setContentType("text/html");
		
		try
		{
			String title = request.getParameter("title");
			int number = Integer.parseInt(request.getParameter("number"));
			String type = request.getParameter("type");
			String member = request.getParameter("member");
			String start = request.getParameter("start");
			String end = request.getParameter("end");
			
			commService.addNewCommittee(title, number, type, member, start, end);
			ModelAndView mav = new ModelAndView("ajax_committeeTable");
			mav.addObject("comms", commService.listCommittees());
			
			return mav;	
		} 
		catch (Exception e)
		{
			System.err.println("UH OH");
			ModelAndView mav = new ModelAndView("ajax_err");
			return mav;
		}
	}
	
	@GetMapping("/ajax/committee/update")
	public ModelAndView ajaxCommUpdate(HttpServletRequest request, HttpServletResponse res)
	{
		res.setContentType("text/html");
		
		try
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			int number = Integer.parseInt(request.getParameter("number"));
			String type = request.getParameter("type");
			String member = request.getParameter("member");
			String start = request.getParameter("start");
			String end = request.getParameter("end");
			
			commService.updateCommittee(id, title, number, type, member, start, end);
			ModelAndView mav = new ModelAndView("ajax_committeeTable");
			mav.addObject("comms", commService.listCommittees());
			
			return mav;
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
			System.err.println("WUH OH");
			ModelAndView mav = new ModelAndView("ajax_err");
			return mav;
		}
	}
	
	@GetMapping("/ajax/committee/remove")
	public ModelAndView ajaxCommRemove(HttpServletRequest request, HttpServletResponse res)
	{
		res.setContentType("text/html");
		
		try
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			commService.removeCommittee(id);
			ModelAndView mav = new ModelAndView("ajax_committeeTable");
			mav.addObject("comms", commService.listCommittees());
			
			return mav;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("WUH OH");
			ModelAndView mav = new ModelAndView("ajax_err");
			return mav;
		}
	}
	
}
