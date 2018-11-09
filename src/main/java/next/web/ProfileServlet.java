package next.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/profile") 
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		User user = DataBase.findUserById(userId);
		if(user == null) {
			throw  new NullPointerException("사용자를 못찾는데이");
		}
		req.setAttribute("user", user);
		RequestDispatcher rd =req.getRequestDispatcher("/user/profile.jsp");    //동적으로 웹페이지 생성
		rd.forward(req, resp);          //클라이언트한테 전달
		
		
		
	}
	
}
