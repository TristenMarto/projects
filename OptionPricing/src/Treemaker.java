import static java.lang.System.out;

import java.util.Arrays;

public class Treemaker {
	
	public static double[][] price_tree(int size, Option option, boolean display_tree){
		double[][] price_tree = new double[size+1][size+1];
		double deltaT = 1./size;
		double u = Math.exp(option.sigma*Math.sqrt(deltaT));
		double d = 1./u;
		
		// creating the price tree
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= i; j++) {
				price_tree[j][i] = option.S0 * Math.pow(u, (i-j)) * Math.pow(d, j);
			}
		}
		
		if (display_tree) {
			out.println("price tree:");
			for (int i = 0; i < price_tree.length; i++){

				out.println(Arrays.toString(price_tree[i]));

				}
		}
		
		return price_tree;
	}
	
	public static double[][] european(double[][] price_tree, Option option, boolean display_tree) {	
		int size = price_tree.length -1;
		double[][] option_tree = new double[size+1][size+1];
		double deltaT = 1./size;
		double u = Math.exp(option.sigma*Math.sqrt(deltaT));
		double d = 1./u;
		double p = (Math.exp(option.r*deltaT) - d) / (u - d);
		
		// Creating the option tree
		for (int row = 0; row <= size; row++) {
			option_tree[row][size] = Math.max(0, price_tree[row][size] - option.K);
		}
				
		for (int col = size-1; col >= -1; col--) {
			for (int row = 0; row <= col; row++) {
				
				double prev_fair_val_1 = option_tree[row][col+1];
				double prev_fair_val_2 = option_tree[row+1][col+1];
				double value = Math.exp(-option.r*deltaT)*(p*(prev_fair_val_1) + (1 - p)*prev_fair_val_2);
				
				option_tree[row][col] = value;
			}
		}
		
		if (display_tree) {
			out.println("option tree:");
			for (int i = 0; i< option_tree.length; i++){

				out.println(Arrays.toString(option_tree[i]));

				}
		} else {
			out.println("fair value at t=0: " + option_tree[0][0]);
		}
		
		
		return option_tree;
		
	}
	
	public static double[][] american(double[][] price_tree, Option option, boolean display_tree){
		int size = price_tree.length -1;
		double[][] option_tree = new double[size+1][size+1];
		double deltaT = 1./size;
		double u = Math.exp(option.sigma*Math.sqrt(deltaT));
		double d = 1./u;
		double p = (Math.exp(option.r*deltaT) - d) / (u - d);
		
		// creating the option tree
		for (int row = 0; row <= size; row++) {
			option_tree[row][size] = Math.max(0, price_tree[row][size] - option.K);
		}
				
		for (int col = size-1; col >= -1; col--) {
			for (int row = 0; row <= col; row++) {
				double prev_fair_val_1 = option_tree[row][col+1];
				double prev_fair_val_2 = option_tree[row+1][col+1];
				double value = Math.exp(-option.r*deltaT)*(p*(prev_fair_val_1) + (1 - p)*prev_fair_val_2);
				double ex_val = Math.max(0, price_tree[row][col] - option.K);
				
				option_tree[row][col] = Math.max(value, ex_val);
			}
		}
		
		if (display_tree) {
			out.println("option tree:");
			for (int i = 0; i< option_tree.length; i++){

				out.println(Arrays.toString(option_tree[i]));

				}
		} else {
			out.println("fair value at t=0: " + option_tree[0][0]);
		}
		
		return option_tree;
	}
}
