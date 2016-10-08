import java.io.IOException;


public class Faces {

	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("USAGE: java Faces training-file.txt "
								+ "training-facit.txt test-file.txt");
			System.exit(-1);
		}

		ParseFiles parser = new ParseFiles();

		try {
			parser.parseImageFile(args[0]);
			parser.parseFacitFile(args[1]);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		parser.getImages().get("Image10").printImage();
		System.out.println("Image35 "+parser.getImageResults().get("Image35"));
	}
}
