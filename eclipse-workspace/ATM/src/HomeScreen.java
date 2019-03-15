import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType; 

public class HomeScreen {
	Scene scene;
	Stage stage;
	LoginForm loginForm;
	Balance balance;
	Transaction transaction=new Transaction();
	
	
	public HomeScreen(Stage stage)
	{
		this.stage = stage; 
	}

	public void prepareScene() {
		
        Alert alert = new Alert(AlertType.NONE); 

		Label screen = new Label();
		Label made = new Label("\"made by osama sherif / ID:6012)");
		//made.setContentDisplay("made by osama sherif / ID:6012);
		
	//	screen.setStyle("-fx-border-width: 100;");
	
		
		screen.setStyle("-fx-border-color: black;");
		screen.setFont(new Font("Arial", 10));
		//screen.setBorder(30);

		Button balanceInquiry = new Button("balanceInquiry");
		Button deposit = new Button("deposit");
		Button withdraw = new Button("withdraw");
		Button previous = new Button("<- previous");
		Button next= new Button("next ->");
		
		GridPane grid= new GridPane();
		grid.add(screen,1,0);
		grid.add(balanceInquiry,0,20);
		grid.add(deposit,1,20);
		grid.add(withdraw,2,20);
		grid.add(previous,0,30);
		grid.add(next,2,30);
		grid.add(made,5,40);
		
		balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event)
			{	
					alert.setAlertType(AlertType.CONFIRMATION);
					System.out.println("asdsad");
					System.out.println("saasasad"+balance.getBalnce());
					screen.setText(("Your Blance IS: "+String.valueOf(balance.getBalnce())));
					//screen.clear();
			}			
		}
		);
		deposit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			
				/*TextInputDialog deposit = new TextInputDialog();
				deposit.setTitle("Deopsit");
				deposit.setHeaderText("Specify your amount");
				deposit.setContentText("Amount:");
				Optional<String> depositAmount = deposit.showAndWait();*/
				//System.out.println(result.get()+"then "+Float.valueOf((result.get())));
				//System.out.println("this" +depositAmount.get());
				//transaction.setTransaction(depositAmount.get());
				TextInputDialog deposit = new TextInputDialog();
				deposit.setTitle("WithDraw");
				deposit.setHeaderText("Add your amount");
				deposit.setContentText("Amount:");
				Optional<String> result ;
				result= deposit.showAndWait();
			
				float amount =Float.valueOf((result.get()));
				balance.deposit(amount);
				transaction.setTransaction( deopsitTransaction(result.get()));	
				
				
				
				
			}
			public String deopsitTransaction(String amount)
			{
				System.out.println("Deposit"+amount);
				return "Deposit"+amount;
			}
			
			
		});
		withdraw.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
	
				TextInputDialog withdraw = new TextInputDialog();
				withdraw.setTitle("WithDraw");
				withdraw.setHeaderText("Add your amount");
				withdraw.setContentText("Amount:");
				Optional<String> result ;
				result= withdraw.showAndWait();
				//	System.out.println(result.get()+"then "+Float.valueOf((result.get())));
				
				Alert notEnogh = new Alert(AlertType.WARNING);
				notEnogh.setTitle("Warning !!");
				notEnogh.setHeaderText("You don't have enough balance ");
				notEnogh.setContentText("Please check your balance first ..");
				
				
					float amount =Float.valueOf((result.get()));
					if(balance.getBalnce()<amount)
							{
							notEnogh.showAndWait();
							}
					else 	
					{
						
						balance.withDraw(amount);
						transaction.setTransaction( WithdrawTransaction(result.get()));	
						
					}
					
			}
			public String WithdrawTransaction (String amount)
			{
				System.out.println("Withdraw"+amount);
				return "Withdraw"+amount;
			}
			
		
		}
		
		);
		previous.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) {
						if (transaction.getDisplayCounter()>1)
						{
							screen.setText(transaction.getPreviousTransaction());

						/*Alert previous = new Alert(AlertType.INFORMATION);
						previous.setTitle("Transaction");
						previous.setHeaderText("Displaying  previous transaction ");
						previous.setContentText(transaction.getPreviousTransaction());

						previous.showAndWait();	*/
						}
						else
						{
							//transaction.setDisplayCounter(2);

							Alert finshed = new Alert(AlertType.INFORMATION);
						finshed.setTitle("Transaction");
						finshed.setHeaderText("there is no transaction before that ");
						finshed.setContentText("to display transaction after click next ");

						finshed.showAndWait();	
						}
							
					}
			
				});
		next.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event) {
				if (transaction.getDisplayCounter()<(transaction.getTransactionCounter()-1)) {
					screen.setText(transaction.getNextTransaction());

				/*Alert next = new Alert(AlertType.INFORMATION);
				next.setTitle("Transaction");
				next.setHeaderText("Displaying next transaction ");
				next.setContentText(transaction.getNextTransaction());

				next.showAndWait();		*/
			}
				else
				{
			//	transaction.setDisplayCounter(transaction.getTransactionCounter());
				Alert finshed = new Alert(AlertType.INFORMATION);
				finshed.setTitle("Transaction");
				finshed.setHeaderText("There is no transaction after that ");
				finshed.setContentText("To display transaction before click previous");

				finshed.showAndWait();	
				}	
		}});

		scene = new Scene(grid,400,200);	
	}
	public LoginForm getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	public Scene getScene()
	{
		//System.out.println("ooooooooooo");
		return this.scene;
	}
	public  void setBalance(Balance balance) {
		this.balance=balance;	
		}
	
}
/*public  void setTransaction(Transaction transaction) {
		this.transaction=transaction;	}
}*/