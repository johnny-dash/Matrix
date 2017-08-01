/***
 * The DenseMatrix implement the Matrix interface
 * matrix family should follow up.
 *
 *	Created by DI Mao <maodi101@gmail.com>
 *	29.7.2017
 */

public class Test{
	public static void main(String args[]){

		double[][] testArray1 = {{1,2},{3,4},{5,6},{7,8}};
		double[][] testArray2 = {{1,4},{2,5},{3,6}};
		double[][] testArray3 = {{1,0,0,0},{0,1,0,0}};
		double[][] testArray4 = {{0,0,0,0},{5,8,0,0},{0,0,3,0},{0,6,0,0}};

		Matrix testMatrix1 = MatrixFactory.getMatrix("dense",testArray1);
		Matrix testMatrix2 = MatrixFactory.getMatrix("dense",testArray2);
		Matrix testMatrix3 = MatrixFactory.getMatrix("diagonal",testArray3);
		Matrix testMatrix4 = MatrixFactory.getMatrix("sparse",testArray4);

		System.out.println("transpose test:");
		testMatrix3.print();
		Matrix transposedMatrix = testMatrix3.transpose();
		transposedMatrix.print();

		System.out.println("times test:");
		testMatrix1.print();
		testMatrix3.print();
		Matrix multipliedMatrix = testMatrix1.times(testMatrix3);
		multipliedMatrix.print();
	}
}