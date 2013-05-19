import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FirstQuestion {

	public static class Point {
		private int x, y;

		public void set(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
		

		public String toString() {
			return "X is " + x + " Y is " + y;
		}
	}

	static Point[] points = new Point[3];

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] array = new int[8][8];
		for (int i = 0; i < 3; i++) {
			points[i] = new Point();
		}

		int temp;
		int max = 0;

		// TODO Auto-generated method stub
		try {
			Scanner in = new Scanner(new FileReader("matrix.txt"));
			
			for(int i=0 ;i<8;i++){
				for(int j =0;j<8;j++){
					array[i][j] = in.nextInt();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		// Saðdan Sola denemeler
		for (int i = 0; i < 8; i++) {
			for (int j = 2; j < 8; j++) {
				if ((array[i][j] * array[i][j - 1] * array[i][j - 2]) > max) {
					points[0].set(i, j);
					points[1].set(i, j - 1);
					points[2].set(i, j - 2);

					max = array[i][j] * array[i][j - 1] * array[i][j - 2];

				}

			}
		}

		// Aþaðýdan Yukarýya Denemeler
		for (int i = 2; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((array[i][j] * array[i - 1][j] * array[i - 2][j]) > max) {
					points[0].set(i, j);
					points[1].set(i - 1, j);
					points[2].set(i - 2, j);

					max = array[i][j] * array[i - 1][j] * array[i - 2][j];

				}

			}
		}

		// Sað alt Çapraz denemeler
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if ((array[i][j] * array[i + 1][j + 1] * array[i + 2][j + 2]) > max) {
					points[0].set(i, j);
					points[1].set(i + 1, j + 1);
					points[2].set(i + 2, j + 2);

					max = array[i][j] * array[i + 1][j + 1]
							* array[i + 2][j + 2];

				}

			}
		}

		// Sol alt Çapraz denemeler
		for (int i = 0; i < 6; i++) {
			for (int j = 2; j < 8; j++) {
				if ((array[i][j] * array[i + 1][j - 1] * array[i + 2][j - 2]) > max) {
					points[0].set(i, j);
					points[1].set(i + 1, j - 1);
					points[2].set(i + 2, j - 2);

					max = array[i][j] * array[i + 1][j - 1]
							* array[i + 2][j - 2];

				}

			}
		}
		
		System.out.println(array[points[0].x][points[0].y]);
		System.out.println(array[points[1].x][points[1].y]);
		System.out.println(array[points[2].x][points[2].y]);
		System.out.println(max);

	}
}
