import static java.lang.System.out;

import java.util.Arrays;

public class Hedger {
	
		public static double[][] hedge(double[][] price_tree, double[][] option_tree, Option option, boolean display_tree) {
			double [][] hedge_tree = new double [price_tree.length][price_tree.length];
						
			if (option_tree.length != price_tree.length) {
				throw new ArrayIndexOutOfBoundsException("matrices niet van zelfde formaat");
			} 
			
			for (int col = price_tree.length - 2; col >= -1; col--) {
				for (int row = 0; row <= col; row++) {
					hedge_tree[row][col] = (option_tree[row][col+1] - option_tree[row+1][col+1]) / 
							(price_tree[row][col+1] - price_tree[row+1][col+1]);
				}
			}
			
			if (display_tree) {
				out.println("delta tree:");
				for (int i = 0; i< hedge_tree.length; i++){

					out.println(Arrays.toString(hedge_tree[i]));

					}
			} else {
				out.println("delta at t=0: " + hedge_tree[0][0]);
			}
			
			return hedge_tree;
		}
}
