package command;

import java.io.*;

import javax.servlet.http.*;

import dao.*;

public class BoardModifyOkCmd implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String idx = request.getParameter("idx");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BoardDAO dao = new BoardDAO();

			int updateCnt = dao.modifyOk(idx, title, content);

			PrintWriter out = response.getWriter();
			out.println("<script>");
			if (updateCnt > 0) {
				out.println("alert('글이 성공적으로 수정되었습니다.')");
				out.println("window.location.href='list.do'");
			} else {
				out.println("alert('글 수정에 실패하였습니다.')");
				out.println("window.location.href='list.do'");
			}
			out.println("</script>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
