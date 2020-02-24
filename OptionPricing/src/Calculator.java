import static java.lang.System.out;

public class Calculator {

	public static void main(String[] args) {
		
		Option option1 = new Option();
		
		option1.setS0(100);
		option1.setR(0.01);
		option1.setSigma(0.20);
		option1.setT(1);
		option1.setK(95);
		
		option1.display();

		double[][] option1_price_tree = Treemaker.price_tree(3, option1, true);
		double [][] option1_option_tree = Treemaker.european(option1_price_tree, option1, true);
		
//		out.println("european option");
//		Treemaker.european(option1_price_tree, option1, true);
//		
//		out.println("american option");
//		Treemaker.american(option1_price_tree, option1, true);
		
		Hedger.hedge(option1_price_tree, option1_option_tree, option1, true);
		
	}	
	
}
