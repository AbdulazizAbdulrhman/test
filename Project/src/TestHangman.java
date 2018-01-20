import java.util.Scanner;
	public class TestHangman {
		public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to Hangman game. Are you ready? OK, let us start:");
			Hangman game = new Hangman();
			game.play();
			}
		}