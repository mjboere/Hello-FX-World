package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import views.AccountView;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		AccountView b = new AccountView(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
