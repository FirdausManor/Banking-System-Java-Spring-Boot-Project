package com.dao.bankingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.constant.UserType;
import com.dao.bankingsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	/* method query */
	List<User> findByStatus(StatusCode status);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User findByUsernameOrEmail(String username, String email);
	
	List<User> findByUserType(UserType userType);
	
	/* complex case */
	// query by SQL
	/*
	@Query(value = "SELECT * FROM m_user u WHERE u.email = :emailParam", nativeQuery = true)
	public User findByEmail(@Param("emailParam") String email);
	*/
	
	// query by JPQL
	/*
	@Query(value = "SELECT u FROM User u WHERE u.userType = :userType", nativeQuery = false)
	public User findByUserType(@Param("userType") UserType userType);
	*/
}