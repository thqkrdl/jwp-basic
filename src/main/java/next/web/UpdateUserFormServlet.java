package next.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/updateForm")
public class UpdateUserFormServlet extends HttpServlet {

	 private static final Logger log = LoggerFactory.getLogger(UpdateUserFormServlet.class);
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = 
				DataBase.findUserById(req.getParameter("userId"));
	//	log.debug("userId : {}", req.getParameter("userId"));
	//	log.debug("Session User : {}", req.getSession().getAttribute("user"));
		if(!UserSessionUtils.isSameUser(req.getSession(), user)) {
			throw new IllegalStateException("다른사람의 정보 수정 안되안되안되요");
		}
		req.setAttribute("user", user);
		RequestDispatcher rd =
				req.getRequestDispatcher("/user/update.jsp");
		rd.forward(req, resp);
	}
}
