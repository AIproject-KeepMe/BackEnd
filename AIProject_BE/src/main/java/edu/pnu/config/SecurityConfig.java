package edu.pnu.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/member/**").authenticated()
		.antMatchers("/manager/**").hasRole("MANAGER")
		.antMatchers("/admin/**").hasRole("ADMIN");
		
		security.csrf().disable();
		security.formLogin().loginPage("/templogin").defaultSuccessUrl("/loginSuccess", true);
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/templogin");
	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		
		String query1 = "select id username, concat('{noop}', password) password, true enabled from member where id=?";
		String query2 = "select id, role from member where id=?";
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(query1)
		.authoritiesByUsernameQuery(query2);
	}
}
