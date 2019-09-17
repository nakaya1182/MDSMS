/**package com.example.demo;

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
        .loginProcessingUrl("/login")//ログイン処理をするURL
        .loginPage("/login")//ログイン画面のURL
        .failureUrl("/login?error")//認証失敗時のURL
        .successForwardUrl("/ItemList")//認証成功時のURL
        .usernameParameter("employee_number")//社員番号のパラメータ名
        .passwordParameter("password");//パスワードのパラメータ名
	}
}*/
