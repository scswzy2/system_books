package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.Category;

public interface CategoryMapper {
	/**
	 * 根据分类名称查找图书分类
	 * @param category
	 * @return 找到返回对象，失败返回null
	 */
	Category findCategory(String category);
	/**
	 * 添加新的图书分类
	 * @param category
	 * @return 1-成功，0-失败
	 */
	int addCategory(String category);
	
	List<Category> listCategory();
	
	int deleteCategory(@Param("id") Integer id);
}
