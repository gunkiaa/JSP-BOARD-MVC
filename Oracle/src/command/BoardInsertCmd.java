package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class BoardInsertCmd implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDAO dao = new BoardDAO();

		int insertCnt = dao.insert(title, content, name);

		try {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if (insertCnt > 0) {
				out.println("alert('글이 성공적으로 작성되었습니다.')");
				out.println("window.location.href='list.do'");
			} else {
				out.println("alert('글 작성이 실패하였습니다.')");
				out.println("window.location.href='list.do'");
			}
			out.println("</script>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
