package com.arun.rest.study.messenger_api.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.arun.rest.study.messenger_api.dao.DatabaseClass;
import com.arun.rest.study.messenger_api.model.Message;

public class MessageService {
	
	DatabaseClass dbClass = new DatabaseClass();
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
				
		messages.put((long) 1, new Message(1, "message one", "arun"));
		messages.put((long) 2, new Message(2, "message two", "mathew"));
		messages.put((long) 3, new Message(3, "message three", "ancy"));
	}
	
	public List<Message> getAllMessageForYear(int year){		
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for(Message m : messages.values()) {
			calendar.setTime(m.getCreated());
			if(calendar.get(Calendar.YEAR) == year)
			{
				messagesForYear.add(m);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getMessagesPaginated(int start, int end){
		List<Message> paginatedMessages = new ArrayList<>(messages.values());
		if(start+end > messages.size()) {
			return paginatedMessages;
		}
		return paginatedMessages.subList(start, start+end);
		
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());		
	}
	
	public Message addMessage(Message message) {
		dbClass.saveMessage(message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;			
	}
	
	public Message deleteMessage(long id) {		
		return messages.remove(id);
	}
}
