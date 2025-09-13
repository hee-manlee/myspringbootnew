package lx.edu.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	 http
	   .authorizeHttpRequests(auth -> auth
	     .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/login.do").permitAll()
	     .requestMatchers("/insert.do").hasRole("ADMIN")
	     .anyRequest().authenticated()
	   )
	   .formLogin(form -> form
	     .loginPage("/login.do")                 // GET login page
	     .loginProcessingUrl("/login.do")        // POST login submit URL
	     .defaultSuccessUrl("/", true)        // where to go after success
	     .failureUrl("/login.do?error")          // on failure
	     .permitAll()
	   )
	   .logout(logout -> logout
	     .logoutUrl("/logout.do")
	     .logoutSuccessUrl("/login.do?logout")
	     .invalidateHttpSession(true)
	     .deleteCookies("JSESSIONID")
	     .permitAll()
	   )
	   .csrf(Customizer.withDefaults());       // keep CSRF enabled (default)
	 return http.build();
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}

