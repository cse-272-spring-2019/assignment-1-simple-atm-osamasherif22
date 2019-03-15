import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm {
	Stage stage;
	HomeScreen homeScreen ;
	Validation validation= new Validation();
	Scene scene;
	Balance balance=new Balance();
	
	public LoginForm(Stage stage)
	{
		this.stage=stage;
	}
	
	public void prepareScene() {
		Label cardLabel = new Label("Card Number:");
		PasswordField cardField=new PasswordField();
		Button login = new Button("login");
		GridPane grid= new GridPane();
		grid.add(cardLabel,0,0);
		grid.add(cardField,0,1);
		grid.add(login, 1, 1);
		login.setOnAction(new EventHandler<ActionEvent>()
		{
			
			@Override
			public void handle(ActionEvent event) {
			//	System.out.println(cardField.getText());
				//System.out.println(balance.getCardNum());
				if ((cardField.getText()).equals(balance.getCardNum()))
				
				{
		//				System.out.println("KKKK");
					balance.deposit(500);
						homeScreen.setBalance(balance);
						stage.setScene(homeScreen.getScene());
				}
			else { //System.out.println("nooo");
				Alert notEnogh = new Alert(AlertType.WARNING);
				notEnogh.setTitle("Warning !!");
				notEnogh.setHeaderText("INVALID card number");
				notEnogh.setContentText(" Please try agin ");
				notEnogh.showAndWait();
			}
			
			}
		}

		
		);
		
		
		scene = new Scene(grid,400,600);
		
	}
	public Scene getScene()
	{
		return this.scene ;

	}

	public HomeScreen getHomeScreen() {
		return homeScreen;
	}

	public void setHomeScreen(HomeScreen homeScreen) {
		this.homeScreen = homeScreen;}
	public Balance getBalanceObject() {
		return balance;
	}
	
	
	
}
