package command;

import java.util.*;

import javax.servlet.http.*;

import dao.*;
import dto.*;

public class BoardListCmd implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
	}
}
