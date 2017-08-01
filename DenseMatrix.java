/***
 * The DenseMatrix implement the Matrix interface
 * matrix family should follow up.
 *
 *	Created by DI Mao <maodi101@gmail.com>
 *	29.7.2017
 */

public class DenseMatrix implements Matrix {

	//This two dimension array is used to store the data for 
	//Dense matrix as every(most) items are important in this matrix 
	private double[][] A;

	//this is used to represent the length and with of the matrix
	private int m, n;

  //this is used to represent the type of the matrix
  private String type = "dense";

	/** 
    * This is construction function for DenseMatrix and it will create a empty 
    * matrix
    *
    * @param n is the index of row
    * @param m is the index of column
	*/
	public DenseMatrix (int m, int n) {
		this.m = m;
		this.n = n;
		A = new double[m][n];
	}

	/** 
    * This is construction function for DenseMatrix and it will create a  
    * matrix by given two dimension array
    *
    * @param A is a two dimension array with double type
	*/
	public DenseMatrix(double A[][]){
	    m = A.length;
        n = A[0].length;
        for (int i = 0; i < m; i++) {
	      	//This is used to check if row has the same lenght
	        if (A[i].length != n) {
	            throw new IllegalArgumentException("All rows must have the same length.");
	        }
        }
      this.A = A;
	}


	/** 
    * This function is used to times wiht other Matrix object
    *
    * @param The other matrix object need to be multiplied
    * @return a matrix object after 
	*/
	public Matrix times (Matrix B) {

		int mB = B.getRowDimension();
		int nB = B.getColumnDimension();
    String type = B.getType();

		//check if times operation is leagal for matrix
		if (mB != n) {
		 throw new IllegalArgumentException("Matrix inner dimensions must agree.");
		}

    if(type == "dense"){
  		Matrix X = new DenseMatrix(m, nB);

  		double[][] C = X.getArray();
  		double[] Bcolj = new double[n];
  		
  		for (int j = 0; j < nB; j++) {
  			for (int k = 0; k < n; k++) {
  				Bcolj[k] = B.get(k,j);
  			}
  			for (int i = 0; i < m; i++) {
  				double[] Arowi = A[i];
  				double s = 0;
  				for (int k = 0; k < n; k++) {
  					s += Arowi[k]*Bcolj[k];
  		    	}
  		    	C[i][j] = s;
  		 	}
  		}

    }else if (type == "diagonal"){

      Matrix X = new DenseMatrix(m, nB);

      double[][] C = X.getArray();

      double[] Barray = B.getArray();

      for(int j = 0; j < m;j++){
        for(int k = 0; k < n; k++){
          C[j][k] = A[j][k] * Barray[j]; 
        }
      }
    }else if (type == "sparse"){
      Matrix X = new DenseMatrix(m, nB);

      double[][] C = X.getArray();
      
    }

    return X;
	}

   /** 
    * This function is used to transpose the matrix function
    *
    * @return a Matrix object after tranpose operation
	*/
	public Matrix transpose(){
      Matrix X = new DenseMatrix(n,m);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            C[j][i] = A[i][j];
         }
      }
      return X;
	}


   /** 
    * Since different matrix might have different data structure. 
    * This function could return two dimension array for calculation or printing matrix
    *
    * @return a two dimension array which represent the matrix 
	*/
	public double[][] getArray () {
      return A;
  	}

   /** 
    * This function is used to get a specific item with index of row and column
    *
    * @param m is the index of row
    * @param n is the index of column
    * @return a double value of the item
	*/
  	public double get(int m, int n){
  		return A[m][n];
  	}

  /** 
   * This function is used to get the type of the matrix(dense, sparse, diagonal)
   *
   * @return a string that represent the type of matrix
   */
   public String getType(){
      return type;
   }



   /** 
    * This function is used to get the row of matrix
	*
    * @return a int that represent the length of row
	*/
  	public int getRowDimension(){
  		return m;
  	}

   /** 
    * This function is used to get the column of matrix
	*
    * @return a int that represent the length of column
	*/
   	public int getColumnDimension(){
   		return n;
    }

   /** 
    * This function is used to print the matrix on console 
	*/
    public void print() {
   		System.out.println("-----------------------");
   		for(int i = 0; i< m; i++){
   			for(int j = 0; j < n; j++){
   				System.out.print(A[i][j]);
   				System.out.print(" ");
   			}
   			System.out.println();
   		}
    }

}