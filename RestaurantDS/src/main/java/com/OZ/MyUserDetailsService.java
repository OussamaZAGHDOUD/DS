package com.OZ;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.OZ.entities.User;
import com.OZ.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService{

	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> opUser = userRepository.findByUserName(userName);
		opUser.orElseThrow(()->new UsernameNotFoundException("User not found ! "+userName));
		return opUser.map(MyUserDetails::new).get();
		
	}

}
