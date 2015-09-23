package ca.mcgill.ecse321.eventregistration.applications;

import ca.mcgill.ecse321.eventregistration.view.EventRegistrationPage;

public class EventAplication {
	public static void main(String[] args) {
		//start UI
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				new EventRegistrationPage().setVisible(true);
			}
		});
	}
}
