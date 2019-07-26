package org.zerock.service;

import org.zerock.domain.EmailKeyVO;

public interface EmailKeyService {
	public EmailKeyVO readEmail(String email) throws Exception;
	public void insertEmail(EmailKeyVO emailKeyVO) throws Exception;
	public void updateEmail(EmailKeyVO emailKeyVO) throws Exception;
}
