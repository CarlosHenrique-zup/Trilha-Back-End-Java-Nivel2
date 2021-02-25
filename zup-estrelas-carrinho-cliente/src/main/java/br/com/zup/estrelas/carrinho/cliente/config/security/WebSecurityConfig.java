package br.com.zup.estrelas.carrinho.cliente.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import lombok.extern.log4j.Log4j2;

@ComponentScan
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Log4j2
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests()
				.antMatchers("/usuario").permitAll().anyRequest().authenticated().and().httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String senhaVerificada = passwordEncoder.encode("senhaUsuario");
		log.info("Password encoded {}", passwordEncoder.encode("test"));
		auth.inMemoryAuthentication().withUser("usuarioTeste").password(senhaVerificada).roles("USER", "ADMIN").and()
				.withUser("adminTeste").password(passwordEncoder.encode("senhaAdmin")).roles("USER");

		System.out.println(senhaVerificada);
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		String senhaVerificada = passwordEncoder.encode("senhaUsuario");
//		log.info("Password encoded {}", passwordEncoder.encode("test"));
//		auth.inMemoryAuthentication().withUser("usuarioTeste").password(senhaVerificada).roles("USER", "ADMIN").and()
//				.withUser("adminTeste").password(passwordEncoder.encode("senhaAdmin")).roles("USER");
//
//		System.out.println(senhaVerificada);
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
