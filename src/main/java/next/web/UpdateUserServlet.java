package next.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=
			LoggerFactory.getLogger(UpdateUserServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		User user = DataBase.findUserById(userId);
		if(!UserSessionUtils.isSameUser(req.getSession(), user)) {
			throw new IllegalStateException("다른사람의 정보 수정 안되안되안되요");
		}
		User updateUser =new User(req.getParameter("userId"),
				req.getParameter("password"),
				req.getParameter("name"),
				req.getParameter("email"));
			log.debug("User : {} ", updateUser);
			DataBase.addUser( updateUser);
			resp.sendRedirect("/user/list");
	
	}
}


