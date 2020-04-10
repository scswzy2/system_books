package com.book.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.book.pojo.Category;
import com.book.pojo.Info;
import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/add_book")
public class AddInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 声明接收数据的变量
			String bookName = null;
			String author = null;
			Category categoryId = null;
			Double price = null;
			String publisher = null;
			String bphoto = null;
			// 获取上传文件的目录(这里表示上传文件的目录为/upload)
			//getRealPath表示获得服务器的绝对路径的意思。
			//ServletContext是接口一个暂时存放数据的地方，上下文关系。
			//通过getServletContext方法得到
			//getServletContext是Servlet（继承了HttpServlet）超类中的方法，
			//返回容器创建的ServletContext实现类的对象。
			String realPath = getServletContext().getRealPath("/static/file");
			// 为基于磁盘的文件项创建DiskFileItemFactory对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 配置存储库（配置文件上传的临时存放位置）
			//getServletConfig通常由容器在文件中指定，允许在运行时向sevrlet传递有关调度信息
			//getServletContext为servlet提供有关容器的信息。此方法可以让servlet在任何时候获得该对象及配置信息
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);//repository表存储
			// 创建新的文件上载处理程序
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置总请求大小约束（字节）
			upload.setSizeMax(100 * 1024 * 1024); // 100M 1byte=8bit 1kb=1024byte 1M=1024kb
			// 设置保存文件的编码方式，
			upload.setHeaderEncoding("UTF-8");
			// 分析请求，把请求参数封装成FileItem类的对象，放入List中(相当于ArrayList)
			//解析表单中的每一个表单项，封装成FileItem对象，以List方式返回。
			List<FileItem> items = upload.parseRequest(request);
			// 遍历list，分别处理每个上传参数
			//Iterator模式是用于遍历集合类的标准访问方法。它可以把访问逻辑从不同类型的集合类中抽象出来，
			//从而避免向客户端暴露集合的内部结构。
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();// 得到当前项，类型为FileItem
				if (item.isFormField()) { // 判断内容是否是普通文本(非文件内容)
					String name = item.getFieldName();// 获取参数名称 userId
					String value = item.getString();// 获取值
					if (StringUtils.isNullOrEmpty(value)) {
						request.setAttribute("error", "内容不能为空");
						request.getRequestDispatcher("/book_mgr").forward(request, response);
						return;
					}
					if (name.equals("bookName"))//书名
						bookName = new String(value.getBytes("ISO-8859-1"), "utf-8");
					else if (name.equals("author"))
						author = new String(value.getBytes("ISO-8859-1"), "utf-8");
					else if (name.equals("categoryId"))
						categoryId = new Category(Integer.valueOf(value), null);
					else if (name.equals("price"))
						price = Double.valueOf(value);
					else
						publisher = new String(value.getBytes("ISO-8859-1"), "utf-8");//出版社
				} else { // 上传的文件数据
					String fileName = item.getName(); // 获取文件名
					//MIME类型就是设定某种扩展名的文件用一种应用程序来打开的方式类型，当该扩展名文件被访问的时候，
					//浏览器会自动使用指定应用程序来打开。多用于指定一些客户端自定义的文件名，
					//以及一些媒体文件打开方式。
					String contentType = item.getContentType();// 获取文件的MIME类型
					// 只能上传的是图片
					if (contentType.equals("image/png") || contentType.equals("image/gif")
							|| contentType.equals("image/jpeg")) {
						//UUID：1经由一定的算法机器生成，2非人工指定，非人工识别，3在特定的范围内重复的可能性极小
						//为了保证UUID的唯一性，规范定义了包括网卡MAC地址、时间戳、名字空间（Namespace）、
						//随机或伪随机数、时序等元素.。randomUUID().toString()是自动生成应该主键的方法
						String rand = UUID.randomUUID().toString();// 获取一个UUID值
						// 上传文件(包含了上传目录和文件名称)
						bphoto = rand + fileName;
						File uploadedFile = new File(realPath, bphoto);
						item.write(uploadedFile);// 把文件保存到上传目录
					} else {// 上传的不是图片
						request.setAttribute("error", "只能上传图片");
						request.getRequestDispatcher("/book_mgr").forward(request, response);
						return;
					}
				}
			}
			// 把对应的内容封装为Info对象
			Info book = new Info(null, bookName, author, categoryId, publisher, price, bphoto);
			// 把Info对象放入数据库
			bookService.addInfo(book);
			// 跳转到book_edit.jsp页面
			request.getRequestDispatcher("/book_mgr").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}