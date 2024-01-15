package com.dao.bankingsystem;

import com.dao.bankingsystem.model.UserProfile;

public class SesseionContext {
	protected static UserProfile userProfile;
	
	public static UserProfile getUserProfile() {
		return userProfile;
	}
	
	public static void setUserProfile(UserProfile _userProfile) {
		userProfile = _userProfile;
	}
	
	public static void clearUserProfile() {
		userProfile = null;
	}
}
