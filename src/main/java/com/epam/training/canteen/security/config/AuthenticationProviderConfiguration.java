package com.epam.training.canteen.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@Import({com.epam.training.canteen.config.DatabaseConfiguration.class})
public class AuthenticationProviderConfiguration {

	@Autowired
	DataSource dataSource;

	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource);
		jdbcImpl.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("SELECT b.username, a.role FROM user_roles a, users b WHERE b.username = ? AND a.username = b.username");
		return jdbcImpl;
	}

}
