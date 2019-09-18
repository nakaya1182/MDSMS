package com.example.demo;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class LoginUserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String employee_number) throws UsernameNotFoundException {
		if (employee_number == null) {
			throw new UsernameNotFoundException("empty");
		}
	System.out.println(employee_number);
	System.out.println(passwordEncoder);


	 /**UserEntity test =userRepository.findByemployee_number(employee_number);


	System.out.print(test);*/


		String password;
		switch (employee_number) {
		case "a":
			password = passwordEncoder.encode("a");
			break;
		default:
			throw new UsernameNotFoundException("not found : " + employee_number);
		}

		return new User(employee_number, password, Collections.emptySet());
	}
}
