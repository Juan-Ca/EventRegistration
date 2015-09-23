package ca.mcgill.ecse321.eventregistration.controller;

import java.sql.Time;

import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Participant;
import ca.mcgill.ecse321.eventregistration.model.RegistrationManager;
import ca.mcgill.ecse321.eventregistration.persistence.PersistenceXStream;

public class EventRegistrationController {
	public EventRegistrationController()
	{
	}
	
	public String createParticipant(String name)
	{
		if(name ==null || name.trim().length() ==0){
			return "Participant name cannot be empty";
		}
		Participant p = new Participant(name);
		RegistrationManager rm = RegistrationManager.getInstance();
		rm.addParticipant(p);
		PersistenceXStream.saveToXMLwithXStream(rm);
		
		return null;
	}
	public String createEvent(String name,Time startTime, Time endTime){
		return null;
	}
	public String register(Participant participant, Event event){
		return null;
	}
}
