package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.CommonDAO;
import org.zerock.dao.MenuInfoDAO;
import org.zerock.domain.MenuInfoVO;

@Service
public class CommonServiceImpl implements CommonService{
	@Inject private CommonDAO commonDAO;
	@Inject private MenuInfoDAO menuInfoDAO;
	
	@Override
	public String selectRcpNo(int rcpNo) {
		return commonDAO.selectRcpNo(rcpNo);
	}
	
	@Override
	public List<MenuInfoVO> getMenuList (MenuInfoVO menuInfoVO){
		return menuInfoDAO.getMenuList(menuInfoVO);
	}
	
}
