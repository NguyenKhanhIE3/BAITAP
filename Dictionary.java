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

	public void add(Word newWord) {
		// TODO Auto-generated method stub
		list.add(newWord);
	}
	public ArrayList<Word> getList()
	{
		return list;
	}
	
}
