import java.io.IOException;
import java.util.HashMap;


public class Perceptron {
	private HashMap<String, FaceImage> trainingImages;
	private HashMap<String, FaceImage> testImages;
	private HashMap<String, Integer> imageResults;

	public Perceptron(String[] args) {
		ParseFiles parser = new ParseFiles();

		try {
			parser.parseImageFile(args[0]);
			parser.parseFacitFile(args[1]);
			parser.parseTestImageFile(args[2]);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		this.trainingImages = parser.getImages();
		this.imageResults = parser.getImageTrueResults();
		this.testImages = parser.getTestImages();
		testImages.get("Image205").printImage();
	}


	public void learning() {

	}

}

