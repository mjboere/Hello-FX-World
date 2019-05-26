package controllers;

import models.Spelbord;
import observers.SpelbordObserver;

public class SpelbordController {

	static SpelbordController spelbordController;
	Spelbord spelbord;
	
	private SpelbordController() {
		spelbord = new Spelbord();
	}
	
	// Singleton Pattern.
	// now we can call: SpelbordController.getInstance()  from everywhere
	// AND it guarantees there is only 1 instance.
	public static SpelbordController getInstance() {
		if (spelbordController == null) {
			spelbordController = new SpelbordController();
		}
		return spelbordController;
	}
	
	public String getScore(){
		return spelbord.getScore();
	}
	
	public void setScore() {
		spelbord.increaseScore();
	}
	
	public void registerObserver(SpelbordObserver sbv) {
		spelbord.register(sbv);
	}
	
}
