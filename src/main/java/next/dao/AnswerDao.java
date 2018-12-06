package next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import core.jdbc.JdbcTemplate;
import next.model.Answer;
import next.model.Question;

public class AnswerDao {
	public List<Answer> findAll(long questionId) throws SQLException {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate();
    	String sql ="SELECT answerId, writer,contents,createdDate,questionId FROM ANSWERS"
    	+" WHERE questionId=?"
    	+" ORDER BY answerId DESC";
    	return jdbcTemplate.query(sql,(ResultSet rs)-> {
     	   return new Answer(
    			   rs.getLong("answerId"),
    			   rs.getString("writer"),
    			   rs.getString("contents"),
    			   rs.getTimestamp("createdDate"),
    			   rs.getLong("questionId"));
       }, questionId);      	
    
}
    	
    public Answer findByUserId(long answerId) throws SQLException {
        	JdbcTemplate jdbcTemplate =
        			new JdbcTemplate();
        	
        	String sql ="SELECT answerId, writer,contents,createdDate,questionId FROM ANSWERS"
        	    	+" WHERE answerId=?";
        	return jdbcTemplate.queryForObject(sql,(ResultSet rs)-> {
         	   return new Answer(
        			   rs.getLong("answerId"),
        			   rs.getString("writer"),
        			   rs.getString("contents"),
        			   rs.getTimestamp("createdDate"),
        			   rs.getLong("questionId"));
           },answerId);      	
    }
}
