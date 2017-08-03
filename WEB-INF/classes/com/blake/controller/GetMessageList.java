package com.blake.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blake.bean.Employee;
import com.blake.bean.Message;
import com.blake.bean.Reply;
import com.blake.service.PrjService;
import com.blake.util.Page;

@Controller
public class GetMessageList {
	@Autowired
	private PrjService prjService;

	/**
	 * @see 处理接收的信息,并保存在数据库,然后重定向至处理消息列表页面的方法
	 * @param mv
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/msgPublish")
	public ModelAndView msgPublish(ModelAndView mv, HttpServletRequest request) {
		String messageContent = request.getParameter("otxt");
		String messageTitle = request.getParameter("title");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Message message = new Message(messageTitle, messageContent, new Date(), employee);
		if(employee.getLead()){//管理层才能发布消息
			System.out.println("管理层发布消息:"+employee.getLead());
			prjService.addMessage(message);
			mv.setViewName("redirect:/msg_");
		}else {
			mv.addObject("error","权限不够");
			mv.setViewName("publishNewMsg");
		}
		System.out.println("title:" + messageTitle + "content:" + messageContent);
		return mv;
	}

	/**
	 * @see 转到发布新消息页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/publish")
	public ModelAndView publishNewMsg(ModelAndView mv) {
		mv.setViewName("publishNewMsg");
		System.out.println("转到发布新消息页面:publishNewMsg() publishNewMsg.jsp");
		return mv;
	}

	/**
	 * @see 转到消息列表页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/msg_")
	public ModelAndView msgListT(ModelAndView mv, HttpServletRequest request) {
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null || "".equals(currentPageStr)) {// 确保参数域中没有currentPage
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		Page page = com.blake.util.PageUtil.createPage(5, prjService.findAllCount(), currentPage);// 动态转换
		List<Message> messages = prjService.findAllMessagee(page);
		request.setAttribute("messages", messages);
		request.setAttribute("page", page);
		mv.setViewName("msgList");
		System.out.println("转到消息列表页面: msgListT()  msgList.jsp");
		return mv;
	}

	/**
	 * @see 显示详细列表
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/mList")
	public ModelAndView mListContent(ModelAndView mv, @RequestParam String messageID, HttpServletRequest request) {
		System.out.println("/mList mListContent() " + messageID);
		if (messageID != null) {
			Message message = prjService.findMessageById(Integer.parseInt(messageID));
			mv.addObject("message", message);
			
			int currentPage = 0;
			String currentPageStr = request.getParameter("currentPage");
			if (currentPageStr == null || "".equals(currentPageStr)) {// 确保参数域中没有currentPage
				currentPage = 1;
			} else {
				currentPage = Integer.parseInt(currentPageStr);
			}
			Page page = com.blake.util.PageUtil.createPage(5, prjService.findCountByMsgID(Integer.parseInt(messageID)),
					currentPage);
			List<Reply> replys = prjService.findReplayByMsgID(Integer.parseInt(messageID), page);
			if(replys!=null){request.setAttribute("replys",replys);request.setAttribute("page",page);}
		}
		mv.setViewName("showMsg");
		return mv;
	}

	/**
	 * @see 回复消息
	 * @param mv
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/commitReply", method = RequestMethod.POST)
	public ModelAndView commitReply(ModelAndView mv, HttpServletRequest request) {
		String content = request.getParameter("content");
		Integer messageID = Integer.parseInt(request.getParameter("messageID"));
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		Message message = prjService.findMessageById(messageID);
		Reply reply = new Reply();
		System.out.println("commitReply()" + content);
		if (employee != null && content != null && message != null) {// 验证和识别
			reply.setEmployee(employee);
			reply.setMessage(message);
			reply.setReplyContent(content);
			reply.setReplyTime(new Date());
			prjService.addReplay(reply);
		} else {
			mv.addObject("error", "write form error!");
			mv.setViewName("showMsg");
			return mv;
		}
		mv.addObject("messageID", messageID);
		mv.setViewName("redirect:/mList");
		return mv;
	}
}
