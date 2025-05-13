package com.yi_college.bookmanager.repository;

import org.apache.ibatis.annotations.Mapper;

import com.yi_college.bookmanager.model.Users;

@Mapper
public interface UserMapper {

	Users findByUsername(String username);

}
