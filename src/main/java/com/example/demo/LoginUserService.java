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
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		System.out.println(name);

		//userRepository.findByEmployee_number(employee_number);

		if(userRepository.findByName(name) != null ) {


		}


		//List<UserEntity> test =userRepository.findAll();
		//System.out.println(test);




		String password;
		switch (name) {
		case "1000":
			password = passwordEncoder.encode("hero1000");
			break;
		default:
			throw new UsernameNotFoundException("not found : " + name);
		case "1001":
			password = passwordEncoder.encode("roku1001");
			break;
		case "1011":
			password = passwordEncoder.encode("satokun1011");
			break;
		case "a":
			password = passwordEncoder.encode("a");
			break;

		}



		return new User(name, password, Collections.emptySet());

	}
}
