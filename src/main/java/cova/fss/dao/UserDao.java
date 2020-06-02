package cova.fss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cova.fss.entities.User;

public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean validate(User user) {
		String sql = "select * from adminLogin where uname = '" + user.getUsername() + "' and pword = '"
				+ user.getPassword() + "'";

		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		if (users.size() > 0) {

			return true;
		} else {
			return false;
		}

	}

	class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();

			user.setUsername(rs.getString("uname"));
			user.setPassword(rs.getString("pword"));

			return user;
		}
	}
}
