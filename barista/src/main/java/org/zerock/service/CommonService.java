package org.zerock.service;

import java.util.List;

import org.zerock.domain.MenuInfoVO;

public interface CommonService {
	
	String selectRcpNo(int rcpNo) ;
	
	//�޴� ����Ʈ
	List<MenuInfoVO> getMenuList (MenuInfoVO menuInfoVO) ;
}
