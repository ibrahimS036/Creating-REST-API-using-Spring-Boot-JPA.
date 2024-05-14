package com.jpa.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.practice.entities.MyBean;
import com.jpa.practice.service.UserService;

@RestController
public class MyController {

	@Autowired
	private UserService userservice;

	@PostMapping("/user")
	public MyBean create(@RequestBody MyBean bean) {
		this.userservice.createUser(bean);
		return bean;
	}

	@GetMapping("/getAll")
	public List<MyBean> alluser() {
		List<MyBean> allUsers = this.userservice.getAllUsers();
		return allUsers;
	}

	@GetMapping("/getbyid/{id}")
	public MyBean findByid(@PathVariable("id") int id) {
		MyBean byId = this.userservice.getById(id);
		return byId;
	}

	@DeleteMapping("/delete/{did}")
	public List<MyBean> delete(@PathVariable("did") int did) {
		List<MyBean> deleteById = this.userservice.deleteById(did);
		return deleteById;
	}

	@PutMapping("/update/{uid}")
	public MyBean update(@RequestBody MyBean bean, @PathVariable("uid") int uid) {
		MyBean updateuser = this.userservice.updateUser(bean, uid);
		return updateuser;
	}

}
