package community.com;

import java.util.Scanner;

public class DictionaryManagement {
	public static void insertFromCommandline(Dictionary dtn)
	{
		Scanner sc = new Scanner (System.in);
		int numberWord = Interger.parse (sc.nextLine());
		for (int i = 0; i<numberWord ;i++)
		{
			String word_target = sc.nextLine();
			String word_explain = sc.nextLine();
			Word newWord = new Word (word_target ,word_explain );
			dtn.add(newWord);
		
					
			
		}
		
	}

}
