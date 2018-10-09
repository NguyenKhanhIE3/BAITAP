package community.com;
import java.util.*;

import java.io.FileInputStream;
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
			String word_target = sc.nextLine();
			String word_explain = sc.nextLine();
			Word newWord = new Word (word_target ,word_explain );
			dtn.add(newWord);
		
					
			
		}
		
	}
	public  void insertFromFile(Dictionary dtn ) 
			throws IOException 
	{
		FileInputStream fis = new FileInputStream("dictionary.txt");
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
		do
		{
		System.out.println("Mời bạn nhập từ  muốn xóa :");
		Scanner scn = new Scanner (System.in);
		String lookup = scn.nextLine();
		int left = 0,right = (list.size())-1;
		do
		{
			int middle = (left +right)/2;
			if (list.get(middle ).getWord_Target().compareTo(lookup)==0 )
			{
				list.remove(list.get(middle));
			}
			else
				if (list.get(middle).getWord_Target().compareTo(lookup)>0)
					right = middle -1 ;
				else
					left = middle +1;
				
		}
		while(left <= right);
		System.out.println("Bạn có muốn  tiếp  tục không :c/k");
		String nhap =new Scanner(System.in).nextLine();
		if (nhap.equalsIgnoreCase("k"))
			break;
		}
		while (true);
		
		
	}
	public  void dictionaryLookup (Dictionary dtn)
	{	
		ArrayList<Word> list = dtn.getList();
		do
		{
		System.out.println("Mời bạn nhập từ :");
		Scanner scn = new Scanner (System.in);
		String lookup = scn.nextLine();
		int left = 0,right = (list.size())-1;
		do
		{
			int middle = (left +right)/2;
			if (list.get(middle).getWord_Target().compareTo(lookup)==0 )
			{
				System.out.print("Nghĩa của từ là :");
				System.out.println(list.get(middle ).getWord_Explain());
				break;
			}
			else
				if (list.get(middle).getWord_Target().compareTo(lookup)>0)
					right = middle-1 ;
				else
					left = middle +1;
				
		}
		while(left <= right);
		System.out.println("Bạn có muốn tra tiếp không :c/k");
		String nhap =new Scanner(System.in).nextLine();
		if (nhap.equalsIgnoreCase("k"))
			break;
		}
		while (true);
		
		
		
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

