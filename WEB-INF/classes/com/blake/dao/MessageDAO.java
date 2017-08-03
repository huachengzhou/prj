package com.blake.dao;

import java.util.List;

import com.blake.bean.Message;
import com.blake.util.Page;
/**
 * @see 消息Dao
 * @author Blake.Zhou
 *
 */
public interface MessageDAO {
	/**
	 * @see 添加消息的方法
	 * @param message
	 */
	public void addMessage(Message message);

	/**
	 * @see 修改消息的方法
	 * @param message
	 */
	public void updateMessage(Message message);

	/**
	 * @see 删除消息的方法
	 * @param messageID
	 */
	public void deleteMessage(int messageID);

	/**
	 * @see 按分页信息查询所有消息的方法
	 * @param page
	 * @return
	 */
	public List<Message> findAllMessagee(Page page);

	/**
	 * @see 按ID查询消息的方法
	 * @param messageID
	 * @return
	 */
	public Message findMessageById(int messageID);

	/**
	 * @see 查询消息记录数
	 * @return
	 */
	public int findAllCount();
}
