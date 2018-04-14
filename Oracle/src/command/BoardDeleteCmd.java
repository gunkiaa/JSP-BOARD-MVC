package command;

import java.io.*;

import javax.servlet.http.*;

import dao.*;

public class BoardDeleteCmd implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String idx = request.getParameter("idx");
		BoardDAO dao = new BoardDAO();
		int deleteCnt = dao.delete(idx);

		try {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if (deleteCnt > 0) {
				out.println("alert('" + idx + "번째 글의 삭제가 완료되었습니다')");
				out.println("window.location.href='list.do'");
			} else {
				out.println("alert('" + idx + "번째 글의 삭제가 실패하였습니다')");
				out.println("window.location.href='list.do'");
			}
			out.println("</script>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
