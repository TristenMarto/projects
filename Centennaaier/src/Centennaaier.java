import static java.lang.System.out;

public class Centennaaier {

	public static void main(String[] args) {
		int totaal = 34;
		int over;
		
		int kwartjes = totaal/25;
		over = totaal%25;
		
		int dubbel = over/10;
		over = over%10;
		
		int stoevoe = over/5;
		over = over%5;
		
		int centen = over;
		
		out.println("je hebt " + totaal + " centen.");
		out.println("dit bestaat uit:");
		out.println(kwartjes + " kwartjes");
		out.println(dubbel + " dubbeltjes");
		out.println(stoevoe + " stoevoes");
		out.println(centen + " centen");
		
	}

}
