import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class Main extends Application {
	public static void main(String[] args) {
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("ATM");
		LoginForm loginForm = new LoginForm(primaryStage);
		HomeScreen homeScreen = new HomeScreen(primaryStage);
		//Transaction transaction = new Transaction(); 
		
		loginForm.prepareScene();
		homeScreen.prepareScene();
		
		
		loginForm.setHomeScreen(homeScreen);
		homeScreen.setLoginForm(loginForm);
		//homeScreen.setTransaction(transaction);
		
		primaryStage.setScene(loginForm.getScene());
		primaryStage.show();

		
		
	}

}

