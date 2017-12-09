package com.arun.rest.study.messenger_api.dao;

import java.util.HashMap;
import java.util.Map;

import com.arun.rest.study.messenger_api.model.Message;
import com.arun.rest.study.messenger_api.model.Profile;

public class Dao {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Long, Message> messages) {
		Dao.messages = messages;
	}
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<Long, Profile> profiles) {
		Dao.profiles = profiles;
	}	
}
