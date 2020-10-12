package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.User;
/**
 * Class: ILoginDao
 * Description: the Dao which extends JPA repository
 * @author SAISHIVA
 * CreatedOn: 2020-10-07
 */
@Repository
public interface ILoginDao extends JpaRepository<User, String>{

	
}
