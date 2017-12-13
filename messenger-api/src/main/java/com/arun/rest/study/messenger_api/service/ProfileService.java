package com.arun.rest.study.messenger_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.arun.rest.study.messenger_api.dao.DatabaseClass;
import com.arun.rest.study.messenger_api.model.Profile;

public class ProfileService {
	
private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
				
		profiles.put("arun", new Profile(1, "arun", "arun", "mathew"));
		profiles.put("ancy", new Profile(2, "ancy", "ancy", "mathew"));
		profiles.put("mathew", new Profile(3, "mathew", "mathew", "devasia"));
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());		
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;			
	}
	
	public Profile deleteProfile(String profileName) {		
		return profiles.remove(profileName);
	}

}
