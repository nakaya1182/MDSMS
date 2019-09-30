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
		System.out.println(employee_number);
		//Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		//System.out.println(nowTime);


		//userRepository.findByEmployee_number(employee_number);

		String employeeNumber = userRepository.findByName(employee_number);

		//String i = employee_number;

//		 String employeeNumber = UserRepository.loginName(i);


if(employeeNumber != null) {
	String password;
    String LP = userRepository.findByPass(employeeNumber);
	password = passwordEncoder.encode(LP);
	return new User(employee_number, password, Collections.emptySet());
}else {
	throw new UsernameNotFoundException("not found : " + employee_number);
}
	}
}
		//List<UserEntity> test =userRepository.findAll();
		//System.out.println(test);




		/**String password;
		switch (employeeNumber) {
		case "employeeNumber":
			password = passwordEncoder.encode("a");
			break;
		default:
			throw new UsernameNotFoundException("not found : " + employee_number);
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



		return new User(employee_number, password, Collections.emptySet());

	}
}*/