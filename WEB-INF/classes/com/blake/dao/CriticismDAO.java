package com.blake.dao;

import com.blake.bean.Criticism;
/**
 * @see ����Dao
 * @author Blake.Zhou
 *
 */
public interface CriticismDAO {
	/**
	 * @see �������
	 * @param criticism
	 */
	public void addCriticism(Criticism criticism); 

	/**
	 * @see ������ID��������
	 * @param messageID
	 * @return
	 */
	public Criticism findCriticismByMsgID(int messageID); 
}
