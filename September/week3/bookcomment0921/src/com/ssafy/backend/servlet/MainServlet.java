package com.ssafy.backend.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.dto.Book;
import com.ssafy.backend.dto.User;
import com.ssafy.backend.service.BookService;
import com.ssafy.backend.service.UserService;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BookService bservice= BookService.getInstance();
	UserService uservice= UserService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		
		switch (action) {
		case "regist":
			doRegist(request,response);
			break;
		case "login":
			doLogin(request,response);
			break;
		case "logout":
			doLogout(request,response);
			break;
		case "list":
			doList(request,response);
			break;
		case "detail":
			doDetail(request,response);
			break;
		case "update":
			doUpdate(request,response);
			break;
		case "delete":
			dodelete(request,response);
			break;
		case "userregist":
			doUserRegist(request,response);
			break;
		}
	}

	private void doUserRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass"); 
		String rec_id = request.getParameter("rec_id");
		User user= new User(id,name,pass,rec_id);
		try {
			int count = uservice.registry(user);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLIntegrityConstraintViolationException e) {
			request.setAttribute("msg", "회원가입 실패: 추천인이 존재하지 않습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			response.sendError(500);
		} 
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn=request.getParameter("isbn");
		
		try {
			bservice.delete(isbn);
			response.sendRedirect(request.getContextPath()+"/main?action=list");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn=request.getParameter("isbn");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String sprice=request.getParameter("price");
		int price=Integer.parseInt(sprice);
		String desc=request.getParameter("desc");
		Book book=new Book(isbn, title, author, price,desc,"");
		System.out.println(book);
		try {
			bservice.update(book);
			response.sendRedirect(request.getContextPath()+"/main?action=detail&isbn="+isbn);
		}catch (SQLIntegrityConstraintViolationException e) {
			request.setAttribute("msg", "도서 정보 수정 실패: 수정에 실패하였습니다.");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException e) {
			response.sendError(500);
		}
	}
	
	
	
	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn= request.getParameter("isbn");
		try {
			request.setAttribute("book", bservice.getBook(isbn));
			RequestDispatcher dispatcher= request.getRequestDispatcher("/detail.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			response.sendError(500);
		}
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		try {
			request.setAttribute("books", bservice.select());
			RequestDispatcher dispatcher= request.getRequestDispatcher("./list.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			response.sendError(500);
		}
		
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		User user= new User(id,"",pass);
		
		try {
			User loginUser=uservice.login(user);
			if(loginUser !=null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath() +"/index.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price")); 
		String desc = request.getParameter("desc");
		Book book= new Book(isbn,title,author,price,desc,"");
		try {
			int count = bservice.insert(book);
			request.setAttribute("book", book);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/regist_result.jsp");
			dispatcher.forward(request, response);
		} catch (SQLIntegrityConstraintViolationException e) {
			request.setAttribute("msg", "도서등록 실패"+ isbn +"은 이미 사용중입니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/regist_result.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			response.sendError(500);
		} 
	}

}
