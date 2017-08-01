/***
 * The DenseMatrix implement the Matrix interface
 * matrix family should follow up.
 *
 *	Created by DI Mao <maodi101@gmail.com>
 *	29.7.2017
 */

class MatrixFactory{

	public static Matrix getMatrix(String name, int m, int n){
		if ( name.equals("dense") )
	      return new DenseMatrix(m,n);
	    else if ( name.equals("sparse") )
	      return new SparseMatrix(m,n);
	    else if ( name.equals("diagonal") )
	      return new DiagonalMatrix(m,n);

	  	return null;
	}

	public static Matrix getMatrix(String name, double[][] A){
		if ( name.equals("dense") )
	      return new DenseMatrix(A);
	    else if ( name.equals("sparse") )
	      return new SparseMatrix(A);
	    else if ( name.equals("diagonal") )
	      return new DiagonalMatrix(A);

	  	return null;
	}
}