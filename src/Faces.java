

public class Faces {

	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("USAGE: java Faces training-file.txt "
								+ "training-facit.txt test-file.txt");
			System.exit(-1);
		}


		Perceptron perceptron = new Perceptron(args);
		perceptron.learning();



	}
}
