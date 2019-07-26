package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MenuInfoVO;

@Repository
public class MenuInfoDAOImpl implements MenuInfoDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.menuInfoMapper";

	@Override
	public List<MenuInfoVO> getMenuList(MenuInfoVO menuInfoVO)  {
		return sqlSession.selectList(namespace+".getMenuList", menuInfoVO);
	}
	
}
