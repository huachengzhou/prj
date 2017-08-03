package com.blake.dao;

import com.blake.bean.Criticism;
/**
 * @see 批复Dao
 * @author Blake.Zhou
 *
 */
public interface CriticismDAO {
	/**
	 * @see 添加批复
	 * @param criticism
	 */
	public void addCriticism(Criticism criticism); 

	/**
	 * @see 按文章ID查找批复
	 * @param messageID
	 * @return
	 */
	public Criticism findCriticismByMsgID(int messageID); 
}
