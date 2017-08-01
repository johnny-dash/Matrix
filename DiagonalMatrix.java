/***
 * This is Matrix Interface which serves as template that all members of  
 * matrix family should follow up.
 *
 *	Created by DI Mao <maodi101@gmail.com>
 *	29.7.2017
 */

public class DiagonalMatrix implements Matrix {

	private double[] A;

	private int m, n, length;

	//this is used to represent the type of the matrix
  	private String type = "diagonal";

	public DiagonalMatrix (int m, int n) {
		this.m = m;
		this.n = n;
		if(m > n){
			length = n;
		}
		else{
			length = m;
		}
		A = new double[length];
	}

	public DiagonalMatrix(int m, int n, double[] A){
		if((m>= A.length) && (n >= A.length)){
			this.m = m;
			this.n = n;
			this.A = A;
		}
		else{
			throw new IllegalArgumentException("Item out of bound.");
		}
	}


	public DiagonalMatrix(double A[][]){
		m = A.length;
		n = A[0].length;
		if(m > n){
			length = n;
		}
		else{
			length = m;
		}

		double[] B = new double[length];

		for (int i = 0; i < m; i++) {
			if (A[i].length != n) {
				throw new IllegalArgumentException("All rows must have the same length.");
			}
			for(int j = 0; j< n; j++){
				if(i == j){
					B[i] = A[i][j];
				}
				else{
					if(A[i][j] != 0){
						throw new IllegalArgumentException("This is not a legal DiagonalMatrix.");
					}
				}
			}
		}
		this.A = B;
	}
	
	public Matrix times (Matrix B){
		int mB = B.getRowDimension();
		int nB = B.getColumnDimension();

		//check if times operation is leagal for matrix
		if (mB != n) {
		 throw new IllegalArgumentException("Matrix inner dimensions must agree.");
		}
		Matrix X = new DenseMatrix(m, nB);

		// double[][] C = X.getArray();
		// double[] Bcolj = new double[n];
		
		// for (int j = 0; j < nB; j++) {
		// 	for (int k = 0; k < n; k++) {
		// 		Bcolj[k] = B.get(k,j);
		// 	}
		// 	for (int i = 0; i < m; i++) {
		// 		if(i == j) {
		// 			double s = 0;
		// 			for (int k = 0; k < n; k++) {
		// 				s += A[j]*Bcolj[k];
		// 	    	}
		// 	    	C[i][j] = s;
		// 	    }
		// 	    else{
		// 	    	C[i][j] = 0.0;
		// 	    }
		//  	}
		// }
		return X;
	}

	public Matrix transpose(){
		return new DiagonalMatrix(n,m,A);
	}

	public double[] getArray () {
		return A;
  	}

  	public double get(int m, int n){
  		if(m == n){
  			return A[m];
  		}
  		else{
  			return 0.0;
  		}
  	}

  /** 
   * This function is used to get the type of the matrix(dense, sparse, diagonal)
   *
   * @return a string that represent the type of matrix
   */
   public String getType(){
      return type;
   }


  	public int getRowDimension(){
  		return m;
  	}

   	public int getColumnDimension(){
   		return n;
   }

	public void print(){
		for(int i = 0; i < m; i++){
			for(int j = 0; j< n; j++){
				if(i == j){
					System.out.print(A[i]);
					System.out.print(" ");
				}
				else{
					System.out.print(0.0);
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}