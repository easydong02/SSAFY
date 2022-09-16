package com.ssafy.edu.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Facade - controller가 집중 포하(포격) -> MVC Pattern
@WebServlet("/boards")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoardService service=BoardService.getInstance();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		if(command !=null && command.equalsIgnoreCase("bfwrite")) {
			response.sendRedirect("./boardwrite.jsp");
		}else if(command !=null && command.equalsIgnoreCase("write")) {
			String writer=request.getParameter("writer");
			String subject=request.getParameter("subject");
			String content=request.getParameter("content");
			boolean isS=service.addBoard(new Board(writer, subject, content));
			//흐름 - 그냥 가 a location.href= response.sendRedirect
			//    - 원하는 객체를 가지고가 forward - RequestDispatcher 패턴
		
			if(isS) {
				request.setAttribute("url", "./boards?command=list");
				request.setAttribute("msg", "글쓰기에 성공했습니다!");
				request.setAttribute("title", "글목록");
				RequestDispatcher dispatcher= request.getRequestDispatcher("./success.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("url", "./boards?command=bfwrite");
				request.setAttribute("msg", "글쓰기에 실패했습니다!");
				request.setAttribute("title", "글쓰기");
				RequestDispatcher dispatcher= request.getRequestDispatcher("./fail.jsp");
				dispatcher.forward(request, response);
			}
		}else if (command !=null && command.equalsIgnoreCase("list")){
			request.setAttribute("boards", service.getBoardList());
			RequestDispatcher dispatcher= request.getRequestDispatcher("./boardList.jsp");
			dispatcher.forward(request, response);
		}else if (command !=null && command.equalsIgnoreCase("detail")){
			String sarticle_no=request.getParameter("article_no");
			int article_no = Integer.parseInt(sarticle_no);
			
			request.setAttribute("board", service.getBoard(article_no));
			RequestDispatcher dispatcher= request.getRequestDispatcher("./boardDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command!=null && command.equalsIgnoreCase("bfupdate")) {
            String sarticle_no=request.getParameter("article_no");
            int article_no=Integer.parseInt(sarticle_no);
            request.setAttribute("board",service.getBoard(article_no));
            RequestDispatcher dispatch=request.getRequestDispatcher("./boardUpdate.jsp");
            dispatch.forward(request, response); 
        }else if(command !=null && command.equalsIgnoreCase("update")) {
			String writer=request.getParameter("writer");
			String subject=request.getParameter("subject");
			String content=request.getParameter("content");
			String saticle_no=request.getParameter("article_no");
			int article_no= Integer.parseInt(saticle_no);
			Board newBoard= new Board(writer,subject,content);
			newBoard.setArticle_no(article_no);
			
			
			
			boolean isS=service.updateBoard(newBoard);
			//흐름 - 그냥 가 a location.href= response.sendRedirect
			//    - 원하는 객체를 가지고가 forward - RequestDispatcher 패턴
		
			if(isS) {
				request.setAttribute("url", "./boards?command=detail&article_no="+article_no);
				request.setAttribute("msg", "업데이트에 성공했습니다!");
				request.setAttribute("title", "글 상세보기");
				RequestDispatcher dispatcher= request.getRequestDispatcher("./success.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("url", "./boards?command=list");
				request.setAttribute("msg", "글 수정에 실패했습니다!");
				request.setAttribute("title", "글목록");
				RequestDispatcher dispatcher= request.getRequestDispatcher("./fail.jsp");
				dispatcher.forward(request, response);
			}
		}else if(command!=null && command.equalsIgnoreCase("delete")) {
            String sarticle_no=request.getParameter("article_no");
            int article_no=Integer.parseInt(sarticle_no);
            boolean isS = service.deleteBoard(article_no);
            
            if(isS) {
				request.setAttribute("url", "./boards?command=list");
				request.setAttribute("msg", "삭제에 성공했습니다!");
				request.setAttribute("title", "글 목록");
				RequestDispatcher dispatcher= request.getRequestDispatcher("./success.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("url", "./boards?command=list");
				request.setAttribute("msg", "글 삭제 실패했습니다!");
				request.setAttribute("title", "글 목록");
				RequestDispatcher dispatcher= request.getRequestDispatcher("./fail.jsp");
				dispatcher.forward(request, response);
			}
        }
		
	}
}
