package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/delete_category")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService=new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		// 获取请求的参数，
		String rId=request.getParameter("id");
		if(StringUtils.isNullOrEmpty(rId)) {
			request.setAttribute("msg", "格式错误");
			request.getRequestDispatcher("/category_access").forward(request, response);
			return;
		}
		//转换为Integer
		Integer id=Integer.valueOf(rId);
		int result = bookService.deleteCategory(id);
		if(result != 0) {
			request.setAttribute("msg","删除分类成功");
		}
		else {
			request.setAttribute("msg","删除分类失败");
		}
		request.getRequestDispatcher("/category_access").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
