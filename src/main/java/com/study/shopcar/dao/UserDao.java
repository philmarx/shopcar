package com.study.shopcar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.shopcar.dmo.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
