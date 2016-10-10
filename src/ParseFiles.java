/* Parses the training file and facit file.
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class ParseFiles {
	private final int NUMBER_OF_IMAGE_ROWS = 20;

	private HashMap<String, FaceImage> images;
	private HashMap<String, FaceImage> testImages;
	private HashMap<String, Integer> ImageTrueResults;


	public ParseFiles() {
		this.images = new HashMap<String, FaceImage>();
		this.testImages = new HashMap<String, FaceImage>();
		this.ImageTrueResults = new HashMap<String, Integer>();
	}


	/*
	 * Parses training-file
	 */
	public void parseImageFile(String trainingFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(trainingFile));
		try {
		    String line = br.readLine();
		    String imageKey;
		    while (line != null) {
		    	if(line.length() > 0) {
				    if(!line.subSequence(0, 1).equals("#")) {
				        if(line.subSequence(0, 5).equals("Image")) {
				        	imageKey = line;
				        	FaceImage faceImage = new FaceImage();
				        	for(int row = 0; row < NUMBER_OF_IMAGE_ROWS; row++) {
				        		String[] numberStrs = br.readLine().split(" ");
				        		int[] rowValues = new int[numberStrs.length];
				        		for(int i = 0; i < numberStrs.length; i++) {
				        			rowValues[i] = Integer.parseInt(numberStrs[i]);
				        		}
				        		faceImage.setImageRow(row, rowValues);
				        	}
				        	images.put(imageKey, faceImage);
				        }
				    }
		    	}
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
	}


	/*
	 * Parses test-file
	 */
	public void parseTestImageFile(String testFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(testFile));
		try {
		    String line = br.readLine();
		    String imageKey;
		    while (line != null) {
		    	if(line.length() > 0) {
				    if(!line.subSequence(0, 1).equals("#")) {
				        if(line.subSequence(0, 5).equals("Image")) {
				        	imageKey = line;
				        	FaceImage faceImage = new FaceImage();
				        	for(int row = 0; row < NUMBER_OF_IMAGE_ROWS; row++) {
				        		String[] numberStrs = br.readLine().split(" ");
				        		int[] rowValues = new int[numberStrs.length];
				        		for(int i = 0; i < numberStrs.length; i++) {
				        			rowValues[i] = Integer.parseInt(numberStrs[i]);
				        		}
				        		faceImage.setImageRow(row, rowValues);
				        	}
				        	testImages.put(imageKey, faceImage);
				        }
				    }
		    	}
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
	}


	/*
	 * Parses facit-file.
	 */
	public void parseFacitFile(String facitFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(facitFile));
		try {
		    String line = br.readLine();
		    while (line != null) {
		    	if(line.length() > 0) {
				    if(!line.subSequence(0, 1).equals("#")) {
				        if(line.subSequence(0, 5).equals("Image")) {
				        	String[] tmp = line.split(" ");
				        	String imageKey = tmp[0];
				        	int imageResult = Integer.parseInt(tmp[1]);
				        	ImageTrueResults.put(imageKey, imageResult);
				        }
				    }
		    	}
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}

	}



	public HashMap<String, FaceImage> getImages() {
		return this.images;
	}

	public HashMap<String, FaceImage> getTestImages() {
		return this.testImages;
	}

	public HashMap<String, Integer> getImageTrueResults() {
		return this.ImageTrueResults;
	}

}
