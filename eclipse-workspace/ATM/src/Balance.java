
public class Balance {
	
	private float balance;
	private	String cardNum = "60126017"; 

public Balance () {
	setBalance(100); 	
}
public void setBalance(float balance)
{
	this.balance=balance;
}
public float getBalnce()
{
	return this.balance ; 
}
public String getCardNum()
{
	return this.cardNum ; 
}
public void withDraw(float balance)
{
	this.balance-=balance;
}

public void deposit(float balance)
{
	this.balance+=balance;
}

}
