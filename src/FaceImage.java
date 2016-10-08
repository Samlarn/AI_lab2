/* Face image objects.
 */

public class FaceImage {
	private int[][] image;

	public FaceImage() {
		this.image = new int[20][20];
	}

	public void setImageValue(int row, int col, int value) {
		this.image[row][col] = value;
	}


	public void setImageRow(int row, int[] rowValues) {
		this.image[row] = rowValues;
	}



	public int[][] getImage() {
		return this.image;
	}


	public int[] getImageRow(int row) {
		return this.image[row];
	}


	public int getImageValueOf(int row, int col) {
		return this.image[row][col];
	}


	public void printImage() {
	    for(int i = 0; i < 20; i++) {
	    	for(int j = 0; j < 20; j++) {
	    		System.out.print(this.image[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	}

}
