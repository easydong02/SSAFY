package com.ssafy.edu.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class MemberServlet extends HttpServlet {
	//싱글톤 - 한번만 생성
	MemberService memServ= MemberService.getInstance();
	String path;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		path=config.getServletContext().getContextPath();
		System.out.println(path);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String command =req.getParameter("command");
		if(command !=null && command.equalsIgnoreCase("login")) {
			String userid=req.getParameter("userid");
			String password=req.getParameter("password");
			Member member= new Member();
			member.setUserId(userid);
			member.setUserPassword(password);
			try {
				Member login = memServ.login(member);
				if(login !=null) {
					req.getSession().setAttribute("login", login);
					req.getSession().setMaxInactiveInterval(60*10);
					resp.sendRedirect(path+"/boards?command=list");
				}else {
					req.getSession().invalidate();                  //세션 제거
					req.setAttribute("url","./index.jsp");
					req.setAttribute("msg","아이디나 패스워드를 확인하십시오.");
					req.setAttribute("title","로그인");
					RequestDispatcher dispatch=req.getRequestDispatcher("./fail.jsp");
					dispatch.forward(req, resp);
				}
			} catch (SQLException e) {
				req.getSession().invalidate();                      //세션 제거
				req.setAttribute("url",path+"/index.jsp");
				req.setAttribute("msg","로그인에 실패하였습니다.");
				req.setAttribute("title","로그인");
				RequestDispatcher dispatch=req.getRequestDispatcher("./fail.jsp");
				dispatch.forward(req, resp); 
			}
		}else if(command !=null && command.equalsIgnoreCase("logout")) {
			req.getSession().invalidate();
			resp.sendRedirect("./index.jsp");
		}else if(command !=null && command.equalsIgnoreCase("bfregi")) {
			req.getSession().invalidate();
			resp.sendRedirect("./memberRegist.jsp");
		}else if(command !=null && command.equalsIgnoreCase("regist")) {
			String userid=req.getParameter("userid");
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String fullEmail=req.getParameter("email");
			String email= fullEmail.split("@")[0];
			System.out.println(email);
			String emailDomain= fullEmail.split("@")[1];
			System.out.println(emailDomain);
			
			Member mem =new Member(userid,username,password,email,emailDomain);
			try {
				boolean chk = memServ.registry(mem);
				if(chk) {
					req.getSession().invalidate();                      //세션 제거
					req.setAttribute("url",path+"/index.jsp");
					req.setAttribute("msg","회원가입에 성공하였습니다. 로그인 해주십시오.");
					req.setAttribute("title","로그인");
					RequestDispatcher dispatch=req.getRequestDispatcher("./success.jsp");
					dispatch.forward(req, resp); 
				}else {
					req.getSession().invalidate();                      //세션 제거
					req.setAttribute("url",path+"/index.jsp");
					req.setAttribute("msg","회원가입에 실패하였습니다.");
					req.setAttribute("title","Home");
					RequestDispatcher dispatch=req.getRequestDispatcher("./index.jsp");
					dispatch.forward(req, resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
