/***
 * This is Matrix Interface which serves as template that all members of  
 * matrix family should follow up.
 *
 *	Created by DI Mao <maodi101@gmail.com>
 *	29.7.2017
 */

import java.util.*;

public class SparseMatrix implements Matrix {
	//Compressed sparse row
	private ArrayList<Double> A = new ArrayList<Double>();
	private int[] IA;
	private ArrayList<Integer> JA = new ArrayList<Integer>();

	private int m, n;

 	//this is used to represent the type of the matrix
 	private String type = "sparse";

	public SparseMatrix(int m, int n){
		this.m = m;
		this.n = n;
		//need to refine
		IA = new int[m + 1];
	}

	public SparseMatrix(double B[][]){
		m = B.length;
		n = B[0].length;
		IA = new int[m + 1];		
		IA[0] = 0;


		for (int i = 0; i < m; i++) {
			if (B[i].length != n) {
				throw new IllegalArgumentException("All rows must have the same length.");
			}

			int nonZero = 0;

			for(int j = 0; j < n; j++){
				if(B[i][j] != 0){
					A.add(B[i][j]);
					nonZero++;
					JA.add(j);
				}
			}

			IA[i+1] = IA[i] + nonZero;
			
		}

		//CSR output test
		// System.out.println("------------------------------------");
		// System.out.println(A);
		// for(int x =0; x<IA.length;x++){
		// 	System.out.print(IA[x]);
		// 	System.out.print(" ");
		// }
		// System.out.println();
		// System.out.println(JA);
	}


	public Matrix times (Matrix B) {
		int mB = B.getRowDimension();
		int nB = B.getColumnDimension();

		//check if times operation is leagal for matrix
		if (mB != n) {
		 throw new IllegalArgumentException("Matrix inner dimensions must agree.");
		}
		Matrix X = new DenseMatrix(m, nB);

		for(int i = 0; i< IA.length; i++){
			
		}
		return null;
	}

	public Matrix transpose(){
		return null;
	}


	public double[][] getArray(){
		return new double[][]{{1}};
	}

   /** 
    * This function is used to get the type of the matrix(dense, sparse, diagonal)
    *
    * @return a string that represent the type of matrix
    */
    public String getType(){
       return type;
    }
 

	public double get(int m, int n){
		return 0;
	}

	public int getRowDimension(){
		return 1;
	}

	public int getColumnDimension(){
		return 1;
	}

	public void print(){

	}

}