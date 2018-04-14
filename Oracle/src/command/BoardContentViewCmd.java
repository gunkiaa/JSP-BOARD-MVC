package command;

import javax.servlet.http.*;

import dao.*;
import dto.*;

public class BoardContentViewCmd implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.contentView(idx);
		
		request.setAttribute("contentView", dto);
	}
}
