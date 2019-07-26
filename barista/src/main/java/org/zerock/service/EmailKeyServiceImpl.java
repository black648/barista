package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.EmailKeyDAO;
import org.zerock.domain.EmailKeyVO;

@Service
public class EmailKeyServiceImpl implements EmailKeyService{
	@Inject
	private EmailKeyDAO emailKeyDAO;
	
	public EmailKeyVO readEmail (String email) throws Exception {
		return emailKeyDAO.readEmail(email);
	}
	public void insertEmail(EmailKeyVO emailKeyVO) throws Exception {
		emailKeyDAO.insertEmail(emailKeyVO);
	}
	public void updateEmail(EmailKeyVO emailKeyVO) throws Exception {
		emailKeyDAO.updateEmail(emailKeyVO);
	}
}
