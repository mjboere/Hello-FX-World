# Hello-FX-World-MVC-Observer

First Draft to demonstrate how we want the structure of the projects to look like.

This implementation of account (-management) uses the Model View Controller (MVC) pattern to link the classes
Thus the view only knows the controller and the controller only knows the model
-  View responsibility = everything to do with the graphics & user interaction
-  Controller responsibility = pass calls to other controllers ( not used here ) and/or make all business decisions
-  Model responsibility = Store data and do some functions purely related to this data.

The Spelbord part implements two other design patterns; 

- Singleton pattern
    This can be found in the controller package  / spelbordController  / getInstance method.
    It ensures there is always only 1 objects of this class alive
   
- Observer pattern  
   Spelbord is an Observable.
     It uses the interface SpelbordObservable to force us to write the needed methods : register and notifyAllObservers
     
   SpelbordView is an observer and uses the abstract class SpelbordObserver to force us to write the  update method .


Note : 
Player scores should not be in Spelbord => They should be in a Player model  ( out of time ) 

Hope this helps! 

Michiel Boere
