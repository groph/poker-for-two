package org.imperfect.games.poker.controllers.events;

import javafx.event.Event;
import javafx.event.EventType;

public class DealEvent extends Event {
	
	public static final EventType<DealEvent> DEAL = new EventType<>(
			Event.ANY, "DEAL");
	
	public DealEvent() {
		super(DEAL);
	}
	
}