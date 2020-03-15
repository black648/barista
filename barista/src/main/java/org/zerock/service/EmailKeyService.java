package org.zerock.service;

import org.zerock.domain.EmailKeyVO;

public interface EmailKeyService {
	EmailKeyVO readEmail(String email) throws Exception;
	void insertEmail(EmailKeyVO emailKeyVO) throws Exception;
	void updateEmail(EmailKeyVO emailKeyVO) throws Exception;
}
