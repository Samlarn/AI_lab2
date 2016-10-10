import java.io.IOException;
import java.util.HashMap;
import java.lang.Math;


public class Perceptron {
	private HashMap<String, FaceImage> trainingImages;
	private HashMap<String, FaceImage> testImages;
	private HashMap<String, Integer> imageFacit;
	private HashMap<String, double[][]> savedWeigths;

	//private double[][] ai_weigths;


	public double[][] initWeigths() {
		double[][] w = new double[400][4];
		for(int j = 0; j < 400; j++) {
			for(int i = 0; i < 4; i++) {
				w[j][i] = 0;
			}
		}
		return w;
	}

	private void fillWeightHashMap() {
		savedWeigths = new HashMap<String, double[][]>();

		for(String image : trainingImages.keySet()) {
			savedWeigths.put(image, initWeigths());
		}

	}

	public Perceptron(String[] args) {
		ParseFiles parser = new ParseFiles();
		savedWeigths = new HashMap<String, double[][]>();

		//this.weigths = new double[400][4];
		initWeigths();

		try {
			parser.parseImageFile(args[0]);
			parser.parseFacitFile(args[1]);
			parser.parseTestImageFile(args[2]);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		this.trainingImages = parser.getImages();
		this.imageFacit = parser.getImageTrueResults();

		fillWeightHashMap();

		this.testImages = parser.getTestImages();

	}



	public double sigmund(double x) {
		double sig = 1 / (1 + Math.exp(x));
		return sig;
	}


	public double[] learning() {
		double learningRate = 0.1;
		double[] error = new double[4];
		for(String image : trainingImages.keySet()) {
			double[] y = {0, 0, 0, 0};
			y[imageFacit.get(image)-1] = 1;
			double[] a = new double[4];

			int imageLength = trainingImages.get(image).getImageAsArray().length;
			System.out.println(image);
			for(int i = 0; i < 4; i++) {
				double sum = 0;
				for(int j = 0; j < imageLength; j++) {
					double pixel = (double)trainingImages.get(image).getImageAsArray()[j];
					sum += pixel * savedWeigths.get(image)[j][i];
				}
				System.out.println("i = "+i+" Sum = "+sum);
				a[i] = sigmund(sum);

				error[i] = y[i] - a[i];


				for(int j = 0; j < imageLength; j++) {
					double pixel = (double)trainingImages.get(image).getImageAsArray()[j];
					savedWeigths.get(image)[j][i] += learningRate * error[i] * pixel;
				}
			}

//			System.out.println(image);
//			for(double lol : error) {
//				System.out.print(lol+", ");
//			}
//			System.out.println();



		}
		return error;
	}


	public HashMap<String, double[][]> getWeigths() {
		return this.savedWeigths;
	}

}





//int pixelIndex = 0;
//double y = (double)imageResults.get(image);
//for(int pixel : trainingImages.get(image).getImageAsArray()) {
//	double sum = 0;
//	for(int j = 0; j < 4; j++) {
//		sum += pixel*weigths[pixelIndex][j];
//	}
//	double a = activationFunction(sum);
//	double error = y - a;
//	for(int j = 0; j < 4; j++) {
//		weigths[pixelIndex][j] = pixel*weigths[pixelIndex][j]+learningRate*error*pixel;
//	}
//	pixelIndex++;
//}


