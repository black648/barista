package org.zerock.dao;

import java.util.List;

import org.zerock.domain.AttachVO;
import org.zerock.domain.MenuInfoVO;

public interface MenuInfoDAO {

	public List <MenuInfoVO> getMenuList(MenuInfoVO menuInfoVO);

}
