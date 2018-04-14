package command;

import javax.servlet.http.*;

public interface Command {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
