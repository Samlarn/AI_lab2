

public class Faces {

	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("USAGE: java Faces training-file.txt "
								+ "training-facit.txt test-file.txt");
			System.exit(-1);
		}


		Perceptron perceptron = new Perceptron(args);
		for(int i = 0; i < 10; i++) {
			perceptron.learning();
		}


//		for(int i = 0; i < 4; i++) {
//			for(int j = 0; j < 5; j++) {
//				System.out.print(", "+perceptron.getWeigths().get("Image31")[j][i]);
//			}
//			System.out.println();
//		}



	}
}
