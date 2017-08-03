package com.blake.dao;

import java.util.HashMap;
import java.util.List;

import com.blake.bean.Message;
import com.blake.bean.Reply;
/**
 * @see 回复 Dao
 * @author Blake.Zhou
 *
 */
public interface ReplyDAO {
	/**
	 * @see 添加回复
	 * @param replay
	 */
	public void addReplay(Reply replay);			
	/**
	 * @see 按文章ID查找回复
	 * @param messageID
	 * @param page
	 * @return
	 */
	public List<Reply> findReplayByMsgID(HashMap<String,Object> hashmap);//传入hashMap int messageID,Page page
	/**
	 * @see 查询消息回复记录数
	 * @param messageID
	 * @return
	 */
	public int findCountByMsgID(Message message);
}
