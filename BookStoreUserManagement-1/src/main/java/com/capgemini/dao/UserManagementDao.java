package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.User;

@Repository
public interface UserManagementDao extends JpaRepository<User, String> {


}
 