package com.blake.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blake.bean.Employee;
import com.blake.bean.Message;
import com.blake.service.PrjService;

@Controller
public class RestController {
	
	@Autowired
	private PrjService prjService;

	@RequestMapping(value = "/deleteMessage")
	public ModelAndView deleteMessage(ModelAndView mv, @RequestParam String messageID) {
		try {
			prjService.deleteMessage(Integer.parseInt(messageID));
			System.out.println("delete: message id"+messageID);
			mv.setViewName("redirect:/msg_");
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping(value="/updateMessage_")
	public ModelAndView updateMessage_(ModelAndView mv, @RequestParam String messageID){
		try {
			Message message = prjService.findMessageById(Integer.parseInt(messageID));
			mv.addObject("message",message);
			mv.setViewName("employee/updateMessage");
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping(value="/updateMessage")
	public ModelAndView updateMessage(ModelAndView mv,HttpServletRequest request){
		try {
			String messageTitle = request.getParameter("messageTitle");
			Integer messageID = Integer.parseInt(request.getParameter("messageID"));
			String messageContent = request.getParameter("messageContent");
			Employee employee = (Employee) request.getSession().getAttribute("employee");
			Message message = new Message();
			message.setEmployee(employee);
			message.setMessageContent(messageContent);
			message.setPublishTime(new Date());
			message.setMessageID(messageID);
			message.setMessageTitle(messageTitle);
			prjService.updateMessage(message);
			mv.setViewName("redirect:/msg_");
		} catch (Exception e) {
		}
		return mv;
	}
}
