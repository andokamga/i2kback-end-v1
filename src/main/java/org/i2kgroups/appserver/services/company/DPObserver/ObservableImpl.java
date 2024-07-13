package org.i2kgroups.appserver.services.company.DPObserver;

import java.util.ArrayList;
import java.util.List;

import org.i2kgroups.appserver.dtos.MotificationDTO;

public class ObservableImpl implements Observable{
	
	private MotificationDTO state;
	private List<Obeserver> obeservers = new ArrayList<>();
	@Override
	public void subscrible(Obeserver obeserver) {
		this.obeservers.add(obeserver);
		
	}

	@Override
	public void unSubscrible(Obeserver obeserver) {
		this.obeservers.remove(obeserver);
		
	}

	@Override
	public void notifyObeservers() {
		for(Obeserver obeserver:obeservers) {
			obeserver.update(this.state);
		}
		
	}
	public void setState(MotificationDTO state) {
		this.state=state;
		this.notifyObeservers();
	}
}
