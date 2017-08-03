package com.blake.dao;

import java.util.HashMap;
import java.util.List;

import com.blake.bean.Message;
import com.blake.bean.Reply;
/**
 * @see �ظ� Dao
 * @author Blake.Zhou
 *
 */
public interface ReplyDAO {
	/**
	 * @see ��ӻظ�
	 * @param replay
	 */
	public void addReplay(Reply replay);			
	/**
	 * @see ������ID���һظ�
	 * @param messageID
	 * @param page
	 * @return
	 */
	public List<Reply> findReplayByMsgID(HashMap<String,Object> hashmap);//����hashMap int messageID,Page page
	/**
	 * @see ��ѯ��Ϣ�ظ���¼��
	 * @param messageID
	 * @return
	 */
	public int findCountByMsgID(Message message);
}
