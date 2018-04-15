package frontcontroller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import command.*;
import dto.*;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	public void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("actionDo");

		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		Command command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		if (com.equals("/list.do")) {
			System.out.println("list.do 실행");
			command = new BoardListCmd();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if (com.equals("/delete.do")) {
			System.out.println("delete.do 실행");
			command = new BoardDeleteCmd();
			command.execute(request, response);
			return;
		} else if (com.equals("/contentView.do")) {
			System.out.println("contentView.do 실행");
			command = new BoardContentViewCmd();
			command.execute(request, response);
			viewPage = "contentView.jsp";
		}else if(com.equals("/writing.do")) {
			System.out.println("writing.do 실행");
			command = new BoardInsertCmd();
			command.execute(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
}
