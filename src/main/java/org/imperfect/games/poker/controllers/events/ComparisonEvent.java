package org.imperfect.games.poker.controllers.events;

import javafx.event.Event;
import javafx.event.EventType;

public class ComparisonEvent extends Event {
	
	public static final EventType<ComparisonEvent> COMPARSION = new EventType<>(
			Event.ANY, "COMPARSION");
	
	public ComparisonEvent() {
		super(COMPARSION);
	}
	
}
