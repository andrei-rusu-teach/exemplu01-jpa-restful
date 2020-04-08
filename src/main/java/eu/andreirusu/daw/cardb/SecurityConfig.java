package eu.andreirusu.daw.cardb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import eu.andreirusu.daw.cardb.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailServiceImpl userDetailsService;

	// Metoda responsabila de stabilirea restictiilor de acces la resurse
	// Daca nu are nimic (i.e. este pustie) implicit este permis orice

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(new BCryptPasswordEncoder());
	}

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//
//		UserDetails user = User.withDefaultPasswordEncoder().username("user")
//				.password("password").roles("USER").build();
//		return new InMemoryUserDetailsManager(user);
//	}

}
