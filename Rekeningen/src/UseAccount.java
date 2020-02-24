import static java.lang.System.out;

public class UseAccount {
	public static void main(String args[]) {
		Account myAccount;
		Account yourAccount;
		
		myAccount = new Account();
		yourAccount = new Account();
		
		myAccount.name = "Gert";
		myAccount.address = "Lelylaan";
		myAccount.balance = 25.4332;
		
		yourAccount.name = "Guus";
		yourAccount.address = "Bomenlaan";
		yourAccount.balance = 30.;
		
		myAccount.display();
		out.println();
		yourAccount.display();
	}
}