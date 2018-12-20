package next.controller.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import core.mvc.Controller;
import next.dao.AnswerDao;
import next.model.Answer;
import next.model.Result;

public class DeleteAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Long answerId= Long.parseLong(req.getParameter("answerId"));
		
		AnswerDao answerDao =new AnswerDao();
		Answer answer = answerDao.findById(answerId);
		answerDao.delete(answerId);
		
		if(answer ==null)
			return null;
		
		answerDao.delete(answerId);
		
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/josn);charest=UTF-8");
		PrintWriter out =resp.getWriter();
		out.println(mapper.writeValueAsString(Result.ok()));
		
		return null;
	}

}
