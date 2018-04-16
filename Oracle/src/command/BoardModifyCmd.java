package command;

import javax.servlet.http.*;

import dao.*;
import dto.*;

public class BoardModifyCmd implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String idx = request.getParameter("idx");
		
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = dao.modify(idx);
		
		request.setAttribute("modify", dto);
	}
}
