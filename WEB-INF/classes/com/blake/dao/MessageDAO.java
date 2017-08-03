package com.blake.dao;

import java.util.List;

import com.blake.bean.Message;
import com.blake.util.Page;
/**
 * @see ��ϢDao
 * @author Blake.Zhou
 *
 */
public interface MessageDAO {
	/**
	 * @see �����Ϣ�ķ���
	 * @param message
	 */
	public void addMessage(Message message);

	/**
	 * @see �޸���Ϣ�ķ���
	 * @param message
	 */
	public void updateMessage(Message message);

	/**
	 * @see ɾ����Ϣ�ķ���
	 * @param messageID
	 */
	public void deleteMessage(int messageID);

	/**
	 * @see ����ҳ��Ϣ��ѯ������Ϣ�ķ���
	 * @param page
	 * @return
	 */
	public List<Message> findAllMessagee(Page page);

	/**
	 * @see ��ID��ѯ��Ϣ�ķ���
	 * @param messageID
	 * @return
	 */
	public Message findMessageById(int messageID);

	/**
	 * @see ��ѯ��Ϣ��¼��
	 * @return
	 */
	public int findAllCount();
}
