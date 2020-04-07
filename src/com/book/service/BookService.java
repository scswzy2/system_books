package com.book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.dao.CategoryMapper;
import com.book.pojo.Category;
import com.book.tools.MyBatisUtil;

public class BookService {
	/**
	 * 添加新的分类
	 * @param category
	 * @return 1-成功，0-失败
	 */
	public int addCategory(String category) {
		//保存返回结果
		int result=0;
		String name=category.trim();
		SqlSession sqlSession=MyBatisUtil.open();
		//查询次分类是否存在
		Category res=sqlSession.getMapper(CategoryMapper.class).findCategory(name);
		//不存在此类，则添加
		if(res==null) {
			result=sqlSession.getMapper(CategoryMapper.class).addCategory(name);
		}
		sqlSession.commit();
		//关闭sqlSession
		MyBatisUtil.close(sqlSession);
		return result;
	}
	/**
	 * 获取所有的分类
	 * @return
	 */
	public List<Category> listCategory() {
		SqlSession sqlSession=MyBatisUtil.open();
		List<Category> categories=sqlSession.getMapper(CategoryMapper.class).listCategory();
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		return categories;
		
	}
	public int deleteCategory(Integer id) {
		SqlSession sqlSession=MyBatisUtil.open();
		id=sqlSession.getMapper(CategoryMapper.class).deleteCategory(id);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		return id;
	}
}
