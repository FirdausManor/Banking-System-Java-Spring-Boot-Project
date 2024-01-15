package com.dao.bankingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dao.bankingsystem.entity.AuthSession;

@Repository
public interface AuthSessionRepository extends JpaRepository<AuthSession, String> {
	List<AuthSession> findByUserId(String userId);
	
	AuthSession findByAccessToken(String accessToken);
	
	List<AuthSession> removeByAccessToken(String accessToken);
}
