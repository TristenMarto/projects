import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

public class SteenPapierScaar {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		out.println("Kies uit steen (1), papier (2) of schaar (3)");
		
		int keuze = keyboard.nextInt();
		int willekeur = new Random().nextInt(3);
		
		if (keuze == willekeur) {
			out.println("Gelijk!");
		}
		
		if (keuze == 1 & willekeur == 2 | keuze == 2 & willekeur == 3 | keuze == 3 & willekeur == 1) {
				out.println("verloren pik");
		} else 
				out.println("Gewonnen pik, echt gaaf man!!!!");
		}
		
	}

