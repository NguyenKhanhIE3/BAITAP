package community.com;

import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	private ArrayList<Word> list;
	public Dictionary ()
	{
		this.list = new ArrayList<>();
	}
	public Dictionary (ArrayList<Word> list)
	{
		this.list = list;
	}
	public void add (Word newWord)
	{
		list.add(newWord);
	}
	public void add (String word_target,String word_explain)
	{
		Word word = new Word ( word_target, word_explain);
		list.add(word);
		
				
	}
	public ArrayList<Word> getList()
	{
		return list;
	}
	
}
