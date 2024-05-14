package com.jpa.practice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.practice.dao.BeanRepo;
import com.jpa.practice.entities.MyBean;

@Service
public class UserService {

	@Autowired
	private BeanRepo beanrepo;

	// Creating user.
	public MyBean createUser(MyBean bean) {
		MyBean save = this.beanrepo.save(bean);
		return save;
	}

	// Getting all users
	public List<MyBean> getAllUsers() {
		List<MyBean> all = this.beanrepo.findAll();
		return all;
	}

	// getting users by their id
	public MyBean getById(int id) {
		MyBean bean = this.beanrepo.findById(id).orElseThrow(() -> new RuntimeException(" User not found"));
		return bean;
	}

	// deleting user by their id.
	public List<MyBean> deleteById(int id) {
		this.beanrepo.deleteById(id);
		return getAllUsers();
	}

	// updating user
	public MyBean updateUser(MyBean bean, int id) {
		MyBean save = this.beanrepo.save(bean);
		return save;
	}

}
