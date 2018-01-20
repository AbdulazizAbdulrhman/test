//Abdulaziz Abdulrhman Alghazi ID:435102241   عبدالعزيز عبدالرحمن الغازي
import java.util.Scanner;
import java.util.Random;
public class Hangman {
	private String[] words = {"program" , "java" , "csc111", "hangman", "project"};
	private char[] hiddenWord;
	private char[] guessedWord;
	public Scanner input= new Scanner(System.in);
		
	
	public Hangman(){
	
	}
	
	private int indexOf(char c){
		
		for(int i=0 ; i<this.hiddenWord.length ; i++)
			if( c == this.hiddenWord[i])
				return i;
			return -1;
	}
	
	
	private void setCharAt(int i , char c , char[] arr){
		
		
		arr[i] = c;
		
	}
	
	private String pickWord(){
		Random r = new Random();
		String result = words[r.nextInt(words.length)];
			return result;
	}
	
	private char[] copyStringToArray(String s){
		return s.toCharArray();
	}
	
	private void printWord(){	
		for(int i =0 ; i<this.guessedWord.length ; i++){
			System.out.print(this.guessedWord[i]);
		}
	}
	
	private boolean isComplete(){
		for(int i=0 ; i<this.guessedWord.length ; i++)
			if(this.guessedWord[i] == '*')
				return false;
		return true;
	}
	
	private void playOneRound(){
		String word = this.pickWord();
		char [] toS = this.copyStringToArray(word);
		this.hiddenWord = new char[toS.length];
		
		for(int i=0 ; i<toS.length ; i++){
			this.hiddenWord[i]=toS[i];
		}
		
		this.guessedWord = new char[toS.length];
		
		for(int i = 0; i<this.guessedWord.length ; i++){
			this.guessedWord[i]='*';
		}
		int mis = 0;
		do{	
			System.out.print("(Guess) Enter a letter in word ");	this.printWord(); System.out.print(" >");
			
			char choice = input.next().charAt(0);
			
			if(this.indexOf(choice)==-1){
				mis++;
				
				boolean f = false;
				
				for(int i=0 ; i<toS.length ; i++ ){
					
					if(toS[i]==choice){
						
						System.out.println(choice +" is already in the word");
						f=true;
					break;
					}
					}
				
				if(!f)
				System.out.println(choice+" is not in the word");
			}
			else
				
				for(int i=0 ; i<this.hiddenWord.length ; i++){
					
					if(this.hiddenWord[i]== choice){
						
						this.setCharAt(this.indexOf(choice), choice, this.guessedWord);
						
						this.setCharAt(this.indexOf(choice), '$', this.hiddenWord);

					}	
				}
		}while(!(this.isComplete()));
		
		System.out.print("The word is ");this.printWord();System.out.println("."+" You missed "+mis+" Time");
		
	}
	
	public void play(){
		
		this.playOneRound();
		
		System.out.print("Do you want to guess another word? Enter y or n>");
		
		char p = input.next().charAt(0);
		
		while(p=='y'){

			this.playOneRound();
			
			System.out.print("Do you want to guess another word? Enter y or n>");
			
			p= input.next().charAt(0);
		}
		
		System.out.print("Goodbye!");
		
		
	}

	public String[] getWords() {
		return words;
	}

	public char[] getHiddenWord() {
		return hiddenWord;
	}
	
	
	
}
