package com.example.demo;/**

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests() // 認証が必要となるURLを設定します
	    .antMatchers("/login").permitAll() // /loginFormは認証不要
	    .antMatchers("/UserList").permitAll() // /loginFormは認証不要
	    .antMatchers("/account/**").permitAll() // /account以下のURLも認証不要
	        .anyRequest().authenticated() // それ以外はすべて認証された状態じゃなきゃダメだよ〜
	    .and()
        .formLogin() // ログインページに飛ばすよ
        .loginProcessingUrl("/login") // ログイン処理をするURL
        .loginPage("/login"); // ログインページのURL

	    http.formLogin()
        .loginProcessingUrl("authenticate")//ログイン処理をするURL
        .loginPage("/login")//ログイン画面のURL
        .failureUrl("/login?error")//認証失敗時のURL
        .successForwardUrl("/UserList")//認証成功時のURL
        .usernameParameter("employee_number")//社員番号のパラメータ名
        .passwordParameter("password");//パスワードのパラメータ名
	}
}*/
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //
			.antMatchers("/login").permitAll() // ログイン画面
			.anyRequest().authenticated(); // その他の全リクエストに対して認証を要求
		http.formLogin() //
			.loginPage("/login").usernameParameter("employee_number").passwordParameter("password") // ログイン画面
			.successForwardUrl("/test") // ログイン成功時に表示するURL
			.permitAll();
		http.logout() //
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // logoutUrl()はPOSTに対応していない
			.logoutSuccessUrl("/login") // ログアウト成功時に表示するURL
			.deleteCookies("JSESSIONID").invalidateHttpSession(true).permitAll();
	}

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
}
