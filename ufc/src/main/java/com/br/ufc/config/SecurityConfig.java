package com.br.ufc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.br.ufc.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImplementacao userDetailsImplementacao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/index").permitAll() // Permito todo mundo acessar /inicio
		.antMatchers("/produto/formulario").hasRole("ADMIN") //Somente pessoa com papel "USER" acessa /pessoa/formulario
		.antMatchers("/produto/show").hasRole("ADMIN")
		.antMatchers("/produto/salvar").hasRole("ADMIN") // Pessoa com papel "USER" ou "ADMIN" acessa /pessoa/salvar
		.antMatchers("/produto/listar").permitAll() // /pessoa/listar todo mundo pode acessar
		.antMatchers("/produto/cart").permitAll()
		
		.anyRequest().authenticated() // o resto precisa está autenticado
		
		.and()
		.formLogin()
		.loginPage("/login") // Esse é o controller que chama nosso formulario
		.permitAll() //permitir acesso para essa url "entrar"
		
		//.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		.and()
		.logout()
		.logoutSuccessUrl("/produto/logar?logout") // logout sucesso
		.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsImplementacao)
		.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**","/images/**"); // ignora e permite uri's com esses arquivos
	}

}