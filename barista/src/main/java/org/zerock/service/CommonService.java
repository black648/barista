package org.zerock.service;

import java.util.List;

import org.zerock.domain.MenuInfoVO;

public interface CommonService {
	
	String selectRcpNo(int rcpNo) ;
	
	//메뉴 리스트
	List<MenuInfoVO> getMenuList (MenuInfoVO menuInfoVO) ;
}
