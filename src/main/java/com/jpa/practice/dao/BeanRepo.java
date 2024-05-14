package com.jpa.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.practice.entities.MyBean;

@Repository
public interface BeanRepo  extends JpaRepository<MyBean, Integer>{

}
