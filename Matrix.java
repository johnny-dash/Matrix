/***
 * This is Matrix Interface which serves as template that all members of  
 * matrix family should follow up.
 *
 *	Created by DI Mao <maodi101@gmail.com>
 *	29.7.2017
 */

public interface Matrix {
	
   /** 
    * This function is used to times wiht other Matrix object
    *
    * @param The other matrix object need to be multiplied
    * @return a matrix object after 
	*/
   public Matrix times(Matrix matrix);


   /** 
    * This function is used to transpose the matrix function
    *
    * @return a Matrix object after tranpose operation
	*/
   public Matrix transpose();


   /** 
    * This function is used to get a specific item with index of row and column
    *
    * @param m is the index of row
    * @param n is the index of column
    * @return a double value of the item
	*/
   public double get(int m, int n);

  /** 
   * This function is used to get the type of the matrix(dense, sparse, diagonal)
   *
   * @return a string that represent the type of matrix
   */
   public String getType();


   /** 
    * This function is used to get the row of matrix
	*
    * @return a int that represent the length of row
	*/
   public int getRowDimension();


   /** 
    * This function is used to get the column of matrix
	*
    * @return a int that represent the length of column
	*/
   public int getColumnDimension();

   /** 
    * This function is used to print the matrix on console 
	*/
   public void print();
}

