package org.zerock.service;

import java.util.List;

import org.zerock.domain.MenuInfoVO;

public interface CommonService {
	
	public String selectRcpNo(int rcpNo) ;
	
	//메뉴 리스트
	public List<MenuInfoVO> getMenuList (MenuInfoVO menuInfoVO) ;
}
