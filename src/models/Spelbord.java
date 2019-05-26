package models;

import java.util.ArrayList;
import java.util.List;

import observers.SpelbordObservable;
import observers.SpelbordObserver;

public class Spelbord implements SpelbordObservable {

	private int scorePlayer1 = 0; 		// Should be in player model - but out of time;
	
	// List of all Observers of this Observable Objects
	private List<SpelbordObserver> observers = new ArrayList<SpelbordObserver>();
	
	public Spelbord() {	
	}
	
	public String getScore(){ 
		return Integer.toString(scorePlayer1);
	}

	public void increaseScore(){
		System.out.println("Spelbord - score increased");
		scorePlayer1++;
		
		// SOMETHING Changed !!  - We need to notify the observers !
		notifyAllObservers();
	}
	
	// Add an observer to the list
	public void register(SpelbordObserver observer){
		observers.add(observer);		
	}

	// Signal all observers that something has changed.
	// Also send <<this>> object to the observers.
	public void notifyAllObservers(){
		for (SpelbordObserver s : observers) {
	         s.update(this);
		}
	} 	
	
}
