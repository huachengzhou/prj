package com.blake.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blake.bean.Employee;
import com.blake.service.PrjService;
import com.blake.util.FormatUtil;

/**
 * ��½
 * 
 * @author Blake.Zhou
 *
 */
@Controller
public class Login {
	@Autowired
	private PrjService prjService;

	/**
	 * @see ת����ʶ��ҳ��
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/prj")
	public String prj(@RequestParam(value = "error", defaultValue = ".") String error, Model model,
			HttpSession session) {
		System.out.println("prj()");
		model.addAttribute("error", error);

		Employee employee = (Employee) session.getAttribute("employee");// �൱�ڴ����˳�����
		if (employee != null) {
			session.removeAttribute("employee");
		}

		return "statusRecognise";
	}

	/**
	 * @see ���ʶ�����˵�ǵ�½,����У��
	 * @param employeeID
	 * @param password
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/statusRecogniseAction")
	public ModelAndView statusRecognise(
			@RequestParam(value = "employeeID", defaultValue = "employeeID") String employeeID,
			@RequestParam(value = "password", defaultValue = "password") String password, HttpSession session,
			RedirectAttributes model) {

		System.out.println("employeeID:" + employeeID + " password:" + password);
		ModelAndView mv = new ModelAndView();
		if (employeeID == null || password == null) {// û����д����
			model.addAttribute("error", "data is not null!");
			model.addFlashAttribute("error");
			mv.setViewName("redirect:/prj");
		} else {
			Employee employee = prjService.findEmployeeById(Integer.parseInt(employeeID));
			String pass = " ";
			if (employee != null) {
				pass = employee.getPassword();
			}
			if (employee != null && pass.equals(password)) {// ��½�ɹ�
				session.setAttribute("employee", employee);
				mv.setViewName("main");
			} else {// ��½ʧ��
				mv.addObject("error", "username and password error!");
				mv.setViewName("redirect:/prj");
			}
		}
		return mv;
	}

	/**
	 * @see ת������ҳ��
	 * @return
	 */
	@RequestMapping(value = "/main_")
	public String main() {
		return "main";
	}

	/**
	 * @see register(ע��)
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/register")
	public ModelAndView addRegister(ModelAndView mv, HttpServletRequest request) {
		mv.setViewName("employee/register");
		System.out.println("addRegister()");
		Employee eForm = new Employee();
		mv.addObject(eForm);//Spring mvc form������
		return mv.addObject(new Employee());
	}

	@RequestMapping(value = "/isRedirect",method=RequestMethod.POST)
	public ModelAndView isRegister(ModelAndView mv,HttpServletRequest request,ModelMap model) {
		System.out.println("isRegister()");
		String employeeName = request.getParameter("employeeName");
		String employeeSex = request.getParameter("employeeSex");
		String employeePhone = request.getParameter("employeePhone");
		String employeePlace = request.getParameter("employeePlace");
		String employeeBirth_ = request.getParameter("employeeBirth");
		String password = request.getParameter("password");
		Integer isLead_ = Integer.parseInt(request.getParameter("isLead"));
		Date employeeBirth = FormatUtil.format(employeeBirth_);
		if (employeeBirth != null && employeeName != null && employeePhone != null && employeePlace != null
				&& employeeSex != null && password != null && isLead_ != null) {
			Employee emp = new Employee();
			emp.setEmployeeBirth(employeeBirth);
			emp.setEmployeeName(employeeName);
			emp.setEmployeePhone(employeePhone);
			emp.setEmployeePlace(employeePlace);
			emp.setPassword(password);
			emp.setEmployeeSex(FormatUtil.format(Integer.parseInt(employeeSex)));
			emp.setLead(FormatUtil.format(isLead_));
			emp.setJoinTime(new Date());
			try {
				System.out.println("employee:"+emp);
				prjService.addEmployee(emp);
				request.getSession().setAttribute("employee",emp);//���뵽Session��
				mv.setViewName("redirect:/main_");//ע��ɹ�
			} catch (Exception e) {
				mv.setViewName("redirect:/register");//ע��ʧ��
			}
		}
		Employee eForm = new Employee();
		mv.addObject(eForm);//Spring mvc form������
		return mv.addObject(new Employee());
	}
}
