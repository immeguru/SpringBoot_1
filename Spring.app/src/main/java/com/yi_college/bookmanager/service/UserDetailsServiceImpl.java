package com.yi_college.bookmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yi_college.bookmanager.model.Users;
import com.yi_college.bookmanager.repository.UserMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userMapper.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("ユーザーが見つかりません。");
		}

		return User

				.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole())
				.disabled(!user.isEnabled())
				.build();
	}
}
