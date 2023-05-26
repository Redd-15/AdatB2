package beadando_2;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		new Menu_handler().startMenu(input);
		input.close();
	}

}
