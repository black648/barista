package org.zerock.dao;

import org.zerock.domain.EmailKeyVO;

public interface EmailKeyDAO {
	public EmailKeyVO readEmail(String email) throws Exception;
	public void insertEmail(EmailKeyVO emailKeyVO) throws Exception;
	public void updateEmail(EmailKeyVO emailKeyVO) throws Exception;
}
