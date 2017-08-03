package com.blake.test;
/**
 * 业务层 测试
 * @author Blake.Zhou
 *
 */

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blake.bean.Criticism;
import com.blake.bean.Employee;
import com.blake.bean.Message;
import com.blake.bean.Reply;
import com.blake.service.PrjService;
import com.blake.util.Page;

import edu.princeton.cs.algs4.StdRandom;
import words.WordSt;
import words.Words;

public class ServiceTest {
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/blake/util/beans.xml");
    private PrjService prjService = ctx.getBean(PrjService.class);
    public void addCriticism() {
    	Criticism criticism = new Criticism(Words.getWords(5),new Date());
    	Message message = new Message();
    	message.setMessageID(16);
    	Employee employee = new Employee();
    	employee.setEmployeeID(3052);
    	criticism.setMessage(message);
    	criticism.setEmployee(employee);
    	prjService.addCriticism(criticism);
    	System.out.println(criticism);
    }
    public void findCriticismByMsgID(){
    	Criticism criticism = prjService.findCriticismByMsgID(4);//测试的是criticism的id
    	System.out.println(criticism);
    }
    public void addEmployee(){
    	Employee employee = new Employee();
    	employee.setEmployeeBirth(new Date());
    	employee.setEmployeeName(Words.getWords(4));
    	employee.setEmployeePhone(StdRandom.uniform(1000,100000)+"");
    	employee.setEmployeePlace("中国");
    	employee.setEmployeeSex(true);
    	employee.setJoinTime(new Date(10000000));
    	employee.setPassword(WordSt.getE());
    	employee.setLead(true);
    	prjService.addEmployee(employee);
    	System.out.println(employee);
    }
    public void updateEmployee(){
    	Employee employee = new Employee();
    	employee.setEmployeeBirth(new Date());
    	employee.setEmployeeName(Words.getWords(4));
    	employee.setEmployeePhone(StdRandom.uniform(1000,100000)+"");
    	employee.setEmployeePlace("中国");
    	employee.setEmployeeSex(true);
    	employee.setJoinTime(new Date(10000000));
    	employee.setPassword(WordSt.getE());
    	employee.setLead(true);
    	employee.setEmployeeID(3);
    	prjService.updateEmployee(employee);
    	System.out.println(employee);
    }
    public void deleteEmployee(){
    	prjService.deleteEmployee(3056);
    	System.out.println("deleteEmployee()");
    }
    public void findAllEmployee(){
    	List<Employee> employees = prjService.findAllEmployee();
    	for (Employee employee : employees) {
			System.out.println("findAllEmployee() "+employee);
		}
    }
    public void findEmployeeById(){
    	Employee employee = prjService.findEmployeeById(3052);
    	System.out.println("findEmployeeById()"+employee);
    }
    public void addMessage(){
    	Message message = new Message();
    	message.setPublishTime(new Date());
    	message.setMessageTitle("今日有事!不上班");
    	message.setMessageContent("家里有事 ,请假一天:"+WordSt.getC());
    	Employee employee = new Employee();
    	employee.setEmployeeID(3);
    	message.setEmployee(employee);
    	prjService.addMessage(message);
    	System.out.println(message);
    }
    public void updateMessage(){
    	Message message = new Message();
    	message.setPublishTime(new Date());
    	message.setMessageTitle("今日有事!不上班");
    	message.setMessageContent("家里有事 ,请假一天:"+WordSt.getC());
    	Employee employee = new Employee();
    	employee.setEmployeeID(3);
    	message.setEmployee(employee);
    	message.setMessageID(20);
    	prjService.updateMessage(message);
    	System.out.println(message);
    }
    public void findAllMessagee(){
    	Page page = new Page();
    	page.setBeginIndex(1);
    	List<Message> messages = prjService.findAllMessagee(page);
    	for (Message message : messages) {
			System.out.println("findAllMessagee() "+message);
		}
    }
    public void findMessageById(){
    	Message message = prjService.findMessageById(23);
    	System.out.println("findMessageById()"+message);
    }
    public void findAllCount(){
    	int num = prjService.findAllCount();
    	System.out.println("message findAllCount()"+num);
    }
    public void deleteMessage(){
    	prjService.deleteMessage(24);
    	System.out.println("deleteMessage()");
    }
    public void addReplay(){
    	Reply replay = new Reply();
    	replay.setReplyTime(new Date());
    	replay.setReplyContent("<P>"+"今天天气很好啊!"+"</p>");
    	Employee employee = new Employee();
    	employee.setEmployeeID(3);
    	Message message = new Message();
    	message.setMessageID(18);
    	replay.setEmployee(employee);
    	replay.setMessage(message);
    	prjService.addReplay(replay);
    	System.out.println("addReplay()"+replay);
    }
    public void findReplayByMsgID(){
    	Page page = new Page();
    	page.setBeginIndex(1);
    	int messageID = 14;
    	List<Reply> replys = prjService.findReplayByMsgID(messageID, page);
    	for (Reply reply : replys) {
			System.out.println("findReplayByMsgID()"+reply);
		}
    }
    public void findCountByMsgID(){
    	int num = prjService.findCountByMsgID(14);
    	System.out.println("findCountByMsgID() "+num);
    }
    public void isit(){
    	DataSource dataSource = ctx.getBean(DataSource.class);
    	System.out.println(dataSource);
    }
    public static void main(String[] args) {
    	ServiceTest serviceTest = new ServiceTest();
    	serviceTest.isit();
//    	serviceTest.addEmployee();
    	serviceTest.findEmployeeById();
	}
}
