package community.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {

	DictionaryManagement dict =new DictionaryManagement();
	public  void showAllWords (Dictionary dtn)
	
	{	System.out.println("No\t| English\t|Vietnamese");
		for (int id =0 ;id<dtn.getList().size();id++)
		{
			Word word = dtn.getList().get(id);
			System.out.println((id+1) +"\t|"+word.getWord_Target()+"\t\t|"+word.getWord_Explain());
			
		}
	}
		public  void dictionaryBasic(Dictionary dtn)
	{
			dict.insertFromCommandline(dtn);
			showAllWords(dtn);
	}
		

public  void dictionaryAdvanced (Dictionary dtn) throws IOException 
{
	dict.insertFromFile(dtn);
	showAllWords(dtn);
	dict.dictionaryLookup(dtn);
}
public  void  dictionarySearcher(Dictionary dtn)
{
	System.out.println("Mời bạn nhập từ  :");
	String line = new Scanner (System.in).nextLine();
	ArrayList<Word> List = new ArrayList<>();
	List = dtn.getList();
	for (int i =0 ;i<List.size();i++)
	{
		if (List.get(i).getWord_Target().contains(line))
			System.out.println(List.get(i).getWord_Target());
	}
	
	
	
}
}