package community.com;
import java.util.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DictionaryManagement {

	public  void insertFromCommandline(Dictionary dtn)
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Mời bạn nhập số từ ");
		int numberWord = Integer.parseInt(sc.nextLine());
		for (int i = 0; i<numberWord ;i++)
		{
			String word_target = sc.next();
			String word_explain = sc.nextLine();
			Word newWord = new Word (word_target ,word_explain );
			dtn.add(newWord);
		
					
			
		}
		
	}
	public  void insertFromFile(Dictionary dtn ) throws FileNotFoundException 
	{
	
		FileInputStream fis  = new FileInputStream("dict.txt");
		Scanner sc = new Scanner (fis);
		while (sc.hasNext())
		{
			String word_target = sc.next();
			String word_explain =sc.nextLine();
			Word newWord = new Word (word_target,word_explain);
			dtn.add(newWord);
			
			
		}
		sc.close();
		
	}
	public   void removeFromCommandLine(Dictionary dtn)
	{
		ArrayList<Word> list = dtn.getList();
		
		System.out.println("Mời bạn nhập từ  muốn xóa :");
	
		String delete_Word= new Scanner (System.in).nextLine();
		int left = 0,right = (list.size())-1;
		do
		{
			int middle = (left +right)/2;
			if (list.get(middle ).getWord_Target().compareTo(delete_Word)==0 )
			{
				list.remove(list.get(middle));
			}
			else
				if (list.get(middle).getWord_Target().compareTo(delete_Word)>0)
					right = middle -1 ;
				else
					left = middle +1;
				
		}
		while(left <= right);
		
		
		
	}
	public void replaceCommandLine( Dictionary dtn )
	{
		ArrayList<Word> list = dtn.getList();
		
		System.out.println("Mời bạn nhập từ cần sửa :");
		String  replace_Word = new Scanner (System.in).nextLine();
		System.out.println("Từ tiếng anh thay thế :");
		String word_target = new Scanner(System .in).nextLine();
		System.out.println("Nghĩa của từ :");
		String word_explain =new Scanner (System.in).nextLine();
		int left = 0,right = (list.size())-1;
		do
		{
			int middle = (left +right)/2;
			if (list.get(middle ).getWord_Target().compareTo(replace_Word)==0 )
			{
				
				list.remove(list.get(middle));
				Word newWord = new Word (word_target,word_explain);
				list.add(newWord);
				break;
				
				
			}
			else
				if (list.get(middle).getWord_Target().compareTo(replace_Word)>0)
					right = middle -1 ;
				else
					left = middle +1;
				
		}
		while(left <= right);
		Collections.sort(list, new Comparator<Word>() {
			@Override
			public  int compare(Word w1 ,Word w2)
			{
				return (w1.getWord_Target().compareTo(w2.getWord_Target()));
			}
		
		});
		
		
	}
	public void addWord (Dictionary dtn)
	{
		ArrayList <Word> list = dtn.getList();
		System.out.println("Mời bạn nhập từ cần thêm  :");
		String  add_Word = new Scanner (System.in).nextLine();
		System.out.println("Nghĩa của từ :");
		String word_explain = new Scanner (System.in).nextLine();
		Word newWord =new Word (add_Word,word_explain);
		dtn.add(newWord);
		Collections.sort(list, new Comparator<Word>() {
			@Override
			public  int compare(Word w1 ,Word w2)
			{
				return (w1.getWord_Target().compareTo(w2.getWord_Target()));
			}
		
		});
	}
	public  void dictionaryLookup (Dictionary dtn)
	{	
		ArrayList<Word> list = dtn.getList();
		
		
		System.out.println("Mời bạn nhập từ :");
		Scanner scn = new Scanner (System.in);
		String lookup = scn.nextLine();
		
		int middle,left = 0,right = (list.size())-1;
		do
		{
			 middle = (left +right)/2;
			if (list.get(middle ).getWord_Target().compareTo(lookup )==0 )
			{
				
				System.out.println("Nghĩa của từ là :");
				System.out.println(list.get(middle).getWord_Explain());
				break;
			}
			else
				if (list.get(middle).getWord_Target().compareTo(lookup)>0)
					right = middle -1 ;
				else
					left = middle +1;
				
		}
		while(left <= right);
	
		
		
		
		
		
}
	public void dictionaryExportToFile (Dictionary dtn)
	{
		ArrayList<Word> wordList = dtn.getList();
		try {
			FileWriter fw = new FileWriter("Output.txt");
			for (int i = 0;i<wordList.size();i++)
			{
				fw.write(wordList.get(i).getWord_Target()+"\t"+wordList.get(i).getWord_Explain());
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

