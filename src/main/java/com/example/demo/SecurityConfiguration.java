package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//認可の設定
		http.authorizeRequests() //
		.antMatchers("/login").permitAll() // ログイン画面
		.anyRequest().authenticated(); // その他の全リクエストに対して認証を要求
		//ログイン設定
		http.formLogin()
		.loginPage("/login").usernameParameter("employee_number").passwordParameter("password") // ログイン画面
		.successForwardUrl("/test") // ログイン成功時に表示するURL
		.permitAll();
		//ログアウト設定
		http.logout() //
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // logoutUrl()はPOSTに対応していない
		.logoutSuccessUrl("/login"); // ログアウト成功時に表示するURL

	}

	//passwordのハッシュ化
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**@Configuration
	    protected static class AuthenticationConfiguration
	    extends GlobalAuthenticationConfigurerAdapter {
	        @Autowired
	        LoginUserService userDetailsService;
	        @Override
	        public void init(AuthenticationManagerBuilder auth) throws Exception {
	            // 認証するユーザーを設定する
	            auth.userDetailsService(userDetailsService)
	            // 入力値をbcryptでハッシュ化した値でパスワード認証を行う
	            .passwordEncoder(new BCryptPasswordEncoder());
	        }
	    }*/

}