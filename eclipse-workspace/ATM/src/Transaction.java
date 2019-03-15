
public class Transaction {
	private int transactionCounter=1; 
	private int displayCounter=0;
		String[] arrayOfTransaction = new String[100];
	/*public Transaction() {
		 transactionCounter=0;
	}*/
	//LinkedList<String>}
	
	//string

	public void setTransaction(String transaction)
	{
		
		this.arrayOfTransaction[transactionCounter++]=transaction;
		displayCounter=transactionCounter-1;
	}
	
	public  String getPreviousTransaction() 
	{
	 	return this.arrayOfTransaction[--displayCounter];
	}
	 public String getNextTransaction()
	 {
		 return this.arrayOfTransaction[++displayCounter];
	 }
	 public int getDisplayCounter()
	 {
		 return this.displayCounter;
	 }
	 public int getTransactionCounter()
	 {
		 return this.transactionCounter;
	 }
	 public void setDisplayCounter(int counter)
	 {
		 this.displayCounter=counter;
	 }
}
