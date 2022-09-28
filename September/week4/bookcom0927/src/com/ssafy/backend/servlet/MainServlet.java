package com.ssafy.backend.servlet;

import java.io.IOException;
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
       
	BookService bservice=BookService.getInstance();
	UserService uservice=UserService.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	public  void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String action =request.getParameter("action");
		String path= "./index.jsp";
		switch (action) {
			case "regist":
				doResist(request,response);
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
				doDel(request,response);
				break;
			case "userregist":
				doUserregist(request,response);
				break;
			case "bfuregist":
				path = doBfuregist(request,response);
				forward(request, response, path);
				break;
			case "bfregist":
				path = doBfregist(request,response);
				redirect(request, response, path);
				break;
		}//
	}
	
	
	private String doBfregist(HttpServletRequest request, HttpServletResponse response) {
		return "/book/regist.jsp";
	}
	public void forward(HttpServletRequest request, HttpServletResponse response,String path) throws ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	public void redirect(HttpServletRequest request, HttpServletResponse response,String path) throws ServletException, IOException{
		response.sendRedirect(request.getContextPath()+path);
	}
	public String doBfuregist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("들어옴");
		try {
			request.setAttribute("users", uservice.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/user/userregist.jsp";
	}
	public void doUserregist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String recId=request.getParameter("rec_id");
		User newUser=new User(id, name, pass, recId);
		
		try {
			uservice.registry(newUser);
			request.setAttribute("msg", "성공적으로 가입되었습니다.");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}catch (SQLIntegrityConstraintViolationException e) {
			request.setAttribute("msg", "회원등록 실패: "+
		id+"는 이미 사용중입니다. 또는  회원가입된 추천인만 추가됩니다");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/userregist.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException e) {
			response.sendError(500);
		}
	}
	public void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn=request.getParameter("isbn");
		try {
			bservice.delete(isbn);
			response.sendRedirect(request.getContextPath()+"/main?action=list");
		}catch (SQLException e) {
			request.setAttribute("msg", "삭제에 실패하였습니다.");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		}catch (SQLException e) {
			request.setAttribute("msg", "도서 정보 수정 실패: 수정에 실패하였습니다.");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}
	public void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn=request.getParameter("isbn");
		try {
			request.setAttribute("book", bservice.getBook(isbn));
			RequestDispatcher dispatcher= request.getRequestDispatcher("/book /detail.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			 response.sendError(500);
		}
	}
	public void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			request.setAttribute("books", bservice.select());
			RequestDispatcher dispatcher= request.getRequestDispatcher("/book/list.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			 response.sendError(500);
		}
	}
	// login /logout 세션 관리 
	public void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=request.getSession();  //세션 얻기
		session.invalidate();                      //세션 제거
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		User user=new User(id, "", pass);
		try {
			User loginUser=uservice.login(user);
			if(loginUser!=null) {
				HttpSession session=request.getSession();     // 세션얻기
				session.setAttribute("loginUser", loginUser); // 세션에 저장
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}else {
				request.setAttribute("msg", "로그인실패: 아이디나 패스워드를 확인하세요.");
				RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			response.sendError(500);
		}
	}
	public void doResist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn=request.getParameter("isbn");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String sprice=request.getParameter("price");
		int price=Integer.parseInt(sprice);
		String desc=request.getParameter("desc")+" : "+request.getRemoteAddr();
		Book book=new Book(isbn, title, author, price,desc,"");
		try {
			bservice.insert(book);
			request.setAttribute("book", book);
			RequestDispatcher dispatcher= request.getRequestDispatcher("/book/regist_result.jsp");
			dispatcher.forward(request, response);
		}catch (SQLIntegrityConstraintViolationException e) {
			request.setAttribute("msg", "도서 등록 실패: "+isbn+"은 이미 사용중입니다.");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/regist.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException e) {
			response.sendError(500);
		}
	}
}
