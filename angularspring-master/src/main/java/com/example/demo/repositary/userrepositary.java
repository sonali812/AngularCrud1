package com.example.demo.repositary;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.user;

@Repository
public interface userrepositary extends JpaRepository<user,Integer>{

	List<user> findByEmail(String email);
}

