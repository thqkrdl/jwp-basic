package next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.jdbc.JdbcTemplate;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import next.model.User;

public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        logger.debug("User : {}", user );
        jdbcTemplate.update(sql,user.getUserId(),user.getPassword(),user.getName(),user.getEmail());
    }
    
    public void update(User user) throws SQLException {
    	JdbcTemplate jdbcTemplate =
        		new JdbcTemplate();
    	String sql ="UPDATE USERS SET password=?,name=?,"
        		+"email=? WHERE userId=?";
        jdbcTemplate.update(sql,user.getPassword(),user.getName(),user.getEmail(),user.getUserId());
    	}
   
@SuppressWarnings("unchecked")
    public List<User> findAll() throws SQLException {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate();
    	String sql ="SELECT userId, password, name, email FROM USERS WHERE userid=?";
    	return (List<User>) jdbcTemplate.query(sql,(ResultSet rs)-> {
     	   return new User(
    			   rs.getString("userId"),
    			   rs.getString("password"),
    			   rs.getString("name"),
    			   rs.getString("email"));
       });      	
    
}
    	
    public User findByUserId(String userId) throws SQLException {
        	JdbcTemplate jdbcTemplate =
        			new JdbcTemplate();
        	

            String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
           return jdbcTemplate.queryForObject(sql,(ResultSet rs)-> {
        	   return new User(
        			   rs.getString("userId"),
        			   rs.getString("password"),
        			   rs.getString("name"),
        			   rs.getString("email"));
           },userId);      	
    }
}
    
    
/*    public String createQueryForInsert() {
    	return "INSERT INTO USERS VALUES (?, ?, ?, ?)";
    
    }
    public String createQueryForUpdate() {
    	return  "UPDATE USERS SET password=?,name=?,"
        		+"email=? WHERE userId=?";
    	
    }
    public void setValueForInsert(User user,PreparedStatement pstmt) throws SQLException {
    	pstmt.setString(1, user.getUserId());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getEmail());

    }
    public void setValueForUpdate(User user,PreparedStatement pstmt) throws SQLException {
    	pstmt.setString(1, user.getPassword());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getUserId());
    }
}*/