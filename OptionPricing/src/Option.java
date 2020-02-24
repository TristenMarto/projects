import static java.lang.System.out;

public class Option {
		double S0;
		double K;
		double r;
		double sigma;
		int T;
		

	public double getS0() {
			return S0;
		}

		public void setS0(double s0) {
			S0 = s0;
		}

		public double getK() {
			return K;
		}

		public void setK(double k) {
			K = k;
		}

		public double getR() {
			return r;
		}

		public void setR(double r) {
			this.r = r;
		}

		public double getSigma() {
			return sigma;
		}

		public void setSigma(double sigma) {
			this.sigma = sigma;
		}

		public int getT() {
			return T;
		}

		public void setT(int t) {
			T = t;
		}

	public void display() {
		out.println("S0: " + S0);
		out.println("K: " + K);
		out.println("r: " + r);
		out.println("sigma: " + sigma);
		out.println("T: " + T);
	}
		
}
