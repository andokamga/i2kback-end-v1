package org.i2kgroups.appserver.services.company.DPObserver;

public interface Observable {

	public void subscrible(Obeserver o);
	public void unSubscrible(Obeserver o);
	public void notifyObeservers();
}
