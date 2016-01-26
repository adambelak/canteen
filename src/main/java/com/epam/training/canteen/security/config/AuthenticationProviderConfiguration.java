package com.epam.training.canteen.security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
public class AuthenticationProviderConfiguration {

	@Bean(name = "authDataSource")
	public DataSource authDataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("database/create-db.sql")
				.addScript("database/insert-data.sql")
				.build();
	}

	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(authDataSource());
		jdbcImpl.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("SELECT b.username, a.role FROM user_roles a, users b WHERE b.username = ?");
		return jdbcImpl;
	}

}
