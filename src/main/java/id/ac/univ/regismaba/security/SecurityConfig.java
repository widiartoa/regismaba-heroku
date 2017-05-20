package id.ac.univ.regismaba.security;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/staf/**").permitAll()
			.antMatchers("/img/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/calon-mahasiswa/**").hasAuthority("1")
			.antMatchers("/staf-verifikasi/**").hasAuthority("2")
			.antMatchers("/staf-registrasi/**").hasAuthority("3")
			.antMatchers("/staf-kesejahteraan/**").hasAuthority("4")
			.antMatchers("/staf-kesehatan/**").hasAuthority("5")
			.antMatchers("/manajer-pendidikan/**").hasAuthority("6")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/").permitAll()
			.and().logout().permitAll();
	}

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		String selectUsername = "SELECT username, password, 1 AS ENABLED FROM user WHERE username=?";
		String selectAuth = "SELECT username, id_role FROM user WHERE username=?";

		auth.jdbcAuthentication().dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery(selectUsername)
			.authoritiesByUsernameQuery(selectAuth);
	}
	
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}