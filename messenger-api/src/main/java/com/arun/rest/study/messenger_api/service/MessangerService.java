package com.arun.rest.study.messenger_api.service;

import java.util.Arrays;
import java.util.List;

import com.arun.rest.study.messenger_api.model.Message;

public class MessangerService {
	
	public List<Message> getAllMessages(){
		
		Message m1 =new Message(1, "message one", "arun");
		Message m2 =new Message(2, "message two", "mathew");
		Message m3 =new Message(3, "message three", "ancy");
		Message m4 =new Message(4, "message four", "aneesh");
		Message m5 =new Message(5, "message five", "neethu");
		
		return Arrays.asList(m1,m2,m3,m4,m5);
	}

}
