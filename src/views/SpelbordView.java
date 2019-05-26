package views;

import java.io.FileInputStream;
import controllers.SpelbordController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Spelbord;
import observers.SpelbordObserver;

public class SpelbordView extends SpelbordObserver {
	
	String kaart = "/resources/wereldkaart.jpg";
	//String file = "C:\\Users\\mjboere\\workspace\\Hello FX World\\src\\wereldkaart.jpg";
	private double width = 1600;
	private double height = 900;
	private double windowAnchorX = 50;
	private double windowAnchorY= 50;
	
	Stage primaryStage;
	SpelbordController spelbordController;
	
	public SpelbordView(Stage s){
		primaryStage = s;
		loadPrimaryStageWithGridPane(createInitialGridPane());
	   	spelbordController = spelbordController.getInstance();
    	
	   	// PASS IT TO THE CONTROLLER WHO WILL PASS IT TO THE MODEL
	   	spelbordController.registerObserver(this);	 
	}
    
  	private void loadPrimaryStageWithGridPane(GridPane gp) {
  		try {
  			GridPane root = gp;
			Scene scene = new Scene(root,width,height);
			primaryStage.setScene(scene);		
			primaryStage.setTitle("WELCOME TO THE GAME");
			primaryStage.setX(windowAnchorX);
			primaryStage.setY(windowAnchorY);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
  	}
	
  	private GridPane createInitialGridPane(){	
  		ImageView image = loadWorldImage();
  		image.addEventFilter(MouseEvent.MOUSE_CLICKED, imageClicked); 
  		Text scoreText = new Text("Player Score");
  		TextField usernameField = new TextField();       
		usernameField.setText(" 00 ");
		
		GridPane gridPane = new GridPane();    
		gridPane.setMinSize(400, 200);
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 
		gridPane.setVgap(5); 
		gridPane.setHgap(5);       
		gridPane.setAlignment(Pos.CENTER); 
		
		gridPane.add(image, 0, 0); 
		gridPane.add(scoreText, 1, 0); 		
		gridPane.add(usernameField, 1, 1); 

		return gridPane;
	}
	
  	private GridPane createUpdatedGridPane(Spelbord sb){	
  		ImageView image = loadWorldImage();
  		image.addEventFilter(MouseEvent.MOUSE_CLICKED, imageClicked); 
  		Text scoreText = new Text("Player Score");
		TextField usernameField = new TextField();       
		usernameField.setText(sb.getScore());
		
		GridPane gridPane = new GridPane();    
		gridPane.setMinSize(400, 200);
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 
		gridPane.setVgap(5); 
		gridPane.setHgap(5);       
		gridPane.setAlignment(Pos.CENTER); 
		
		gridPane.add(image, 0, 0); 
		gridPane.add(scoreText, 1, 0); 		
		gridPane.add(usernameField, 1, 1); 

		return gridPane;
	}
  	
  	private ImageView loadWorldImage() {
  		ImageView imageView = null;
  		try {
  			Image image = new Image(getClass().getResource(kaart).toURI().toString());
  					//Image image = new Image(new FileInputStream(file));
			imageView = new ImageView(image);
			return imageView;
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
		return imageView;	 			
  	}
  	
    
    EventHandler<MouseEvent> imageClicked = new EventHandler<MouseEvent>() { 
	    @Override 
	    public void handle(MouseEvent e) { 
	    	 System.out.println("image Gedrukt");
	    	 spelbordController.setScore();
		} 
    }; 

  	@Override
	public void update(Spelbord sb) {
  		loadPrimaryStageWithGridPane(createUpdatedGridPane(sb));
	}
      
    
}
