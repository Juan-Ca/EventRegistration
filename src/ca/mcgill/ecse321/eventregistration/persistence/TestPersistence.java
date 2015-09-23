package ca.mcgill.ecse321.eventregistration.persistence;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Participant;
import ca.mcgill.ecse321.eventregistration.model.Registration;
import ca.mcgill.ecse321.eventregistration.model.RegistrationManager;

public class TestPersistence {

	@Before
	public void setUp() throws Exception {
		RegistrationManager rm = RegistrationManager.getInstance();
		
		// create participant
		Participant pa = new Participant("Martin");
		Participant pa2 = new Participant("Jennifer");
		
		Calendar c =Calendar.getInstance();
		c.set(2015, Calendar.SEPTEMBER,15,8,30,0);
		Date eventDate = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2015, Calendar.SEPTEMBER,15,10,0,0);
		Time endTime = new Time(c.getTimeInMillis());
		Event ev = new Event("Concert", eventDate, startTime, endTime);
		
		//register participants to event
		Registration re = new Registration(pa, ev);
		Registration re2 = new Registration(pa2, ev);
		
		// manage registrations
		rm.addRegistration(re);
		rm.addRegistration(re2);
		rm.addEvent(ev);
		rm.addParticipant(pa);
		rm.addParticipant(pa2);
		
	}

	@After
	public void tearDown() throws Exception {
		// clear all registrations
		RegistrationManager rm = RegistrationManager.getInstance();
		rm.delete();
	}

	@Test
	public void test() {
		// save model
		RegistrationManager rm = RegistrationManager.getInstance();
		PersistenceXStream.setFilename("src\\ca\\mcgill\\ecse321\\eventregistration\\test\\persistence\\data.xml");
		PersistenceXStream.setAlias("event",Event.class);
		PersistenceXStream.setAlias("participant", Participant.class);
		PersistenceXStream.setAlias("registration", Registration.class);
		PersistenceXStream.setAlias("manager", RegistrationManager.class);
		if(!PersistenceXStream.saveToXMLwithXStream(rm))
			fail("could not save file");
		
	}

}
