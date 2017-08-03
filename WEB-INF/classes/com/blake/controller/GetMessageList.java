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
	 * @see ������յ���Ϣ,�����������ݿ�,Ȼ���ض�����������Ϣ�б�ҳ��ķ���
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
		if(employee.getLead()){//�������ܷ�����Ϣ
			System.out.println("����㷢����Ϣ:"+employee.getLead());
			prjService.addMessage(message);
			mv.setViewName("redirect:/msg_");
		}else {
			mv.addObject("error","Ȩ�޲���");
			mv.setViewName("publishNewMsg");
		}
		System.out.println("title:" + messageTitle + "content:" + messageContent);
		return mv;
	}

	/**
	 * @see ת����������Ϣҳ��
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/publish")
	public ModelAndView publishNewMsg(ModelAndView mv) {
		mv.setViewName("publishNewMsg");
		System.out.println("ת����������Ϣҳ��:publishNewMsg() publishNewMsg.jsp");
		return mv;
	}

	/**
	 * @see ת����Ϣ�б�ҳ��
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/msg_")
	public ModelAndView msgListT(ModelAndView mv, HttpServletRequest request) {
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null || "".equals(currentPageStr)) {// ȷ����������û��currentPage
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		Page page = com.blake.util.PageUtil.createPage(5, prjService.findAllCount(), currentPage);// ��̬ת��
		List<Message> messages = prjService.findAllMessagee(page);
		request.setAttribute("messages", messages);
		request.setAttribute("page", page);
		mv.setViewName("msgList");
		System.out.println("ת����Ϣ�б�ҳ��: msgListT()  msgList.jsp");
		return mv;
	}

	/**
	 * @see ��ʾ��ϸ�б�
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
			if (currentPageStr == null || "".equals(currentPageStr)) {// ȷ����������û��currentPage
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
	 * @see �ظ���Ϣ
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
		if (employee != null && content != null && message != null) {// ��֤��ʶ��
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
