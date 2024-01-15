package com.dao.bankingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.dao.bankingsystem.model.ApplicationInfo;

@Component
public class ApplicationInfoProvider {
	@Value("${bs.app.name}") //Binding Property
	protected String appName;
	
	@Autowired
	protected Environment environment;
	
	public String getAppName() {
		return appName;
	}
	
	public String getAppVersion() {
		return environment.getProperty("bs.app.version");
	}
	
	public ApplicationInfo getApplicationInfo() {
		ApplicationInfo applicationInfo = new ApplicationInfo();
		applicationInfo.setAppName(getAppName());
		applicationInfo.setAppVersion(getAppVersion());
		
		return applicationInfo;
	}
}
