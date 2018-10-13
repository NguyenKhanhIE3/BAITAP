package community.com;
import java.util.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DictionaryManagement {
	
	//hàm nhập dữ liệu từ vựng từ bàn phím 
	
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
	// cải tiến 1
	//hàm nhập dữ liệu từ điển từ tệp 
	public  void insertFromFile(Dictionary dtn ) throws FileNotFoundException 
	{
	
		FileInputStream fis = new FileInputStream("dict.txt");
		Scanner sc= new Scanner (fis);
		String s ;
		while (sc.hasNext())
		{
		
			s =sc.nextLine();
			for(int i=0;i<s.length();i++)
			{
				if (s.charAt(i)=='\t')
				{
					Word newWord = new Word (s.substring(0, i),s.substring(i+1));
					dtn.add(newWord);
					break;
				}
				
					
			}
			
			
			
		}
		ArrayList<Word >list = dtn.getList();
		Collections.sort(list, new Comparator<Word>() {
			@Override
			public  int compare(Word w1 ,Word w2)
			{
				return (w1.getWord_Target().compareTo(w2.getWord_Target()));
			}
		
		});
		sc.close();
		
	}
	//cải tiến 2 
	// hàm xóa từ 
	public   void removeFromCommandLine(Dictionary dtn)
	{
		ArrayList<Word> list = dtn.getList();
		
		System.out.println("Moi ban nhap tu muon xoa  :");
	
		String delete_Word= new Scanner (System.in).nextLine();
		int left = 0,right = (list.size())-1;
		while (left<=right)
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
		
		
		
		
	}
	//cải tiến 2 
	//hàm sửa từ 
	public void replaceCommandLine( Dictionary dtn )
	{
		ArrayList<Word> list = dtn.getList();
		
		System.out.println("Moi ban nhap tu can sua  :");
		String  replace_Word = new Scanner (System.in).nextLine();
		System.out.println("Tu tieng anh thay the :");
		String word_target = new Scanner(System .in).nextLine();
		System.out.println("Nghia cua tu :");
		String word_explain =new Scanner (System.in).nextLine();
		int left = 0,right = (list.size())-1;
		while (left<=right)
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

		Collections.sort(list, new Comparator<Word>() {
			@Override
			public  int compare(Word w1 ,Word w2)
			{
				return (w1.getWord_Target().compareTo(w2.getWord_Target()));
			}
		
		});
		
		
	}
	//cải tiến 2 
	//hàm thêm từ 
	public void addWord (Dictionary dtn)
	{
		ArrayList <Word> list = dtn.getList();
		System.out.println("Moi ban nhap tu can them  :");
		String  add_Word = new Scanner (System.in).nextLine();
		System.out.println("Nghia cua tu :");
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
	//cải tiến 1  
	//hàm tra cứu từ điển bằng dòng lệnh 
	public  void dictionaryLookup (Dictionary dtn)
	{	
		ArrayList<Word> list = dtn.getList();
		
		
		System.out.println("Moi ban nhap tu:");
		Scanner scn = new Scanner (System.in);
		String lookup = scn.nextLine();
		
		int middle,left = 0,right = (list.size())-1;
		while (left <=right)
		{
			 middle = (left +right)/2;
			if (list.get(middle ).getWord_Target().compareTo(lookup)==0 )
			{
				
				System.out.println("Nghia cua tu :");
				System.out.println(list.get(middle).getWord_Explain());
				break;
			}
			else
				if (list.get(middle).getWord_Target().compareTo(lookup)>0)
					right = middle -1 ;
				else
					left = middle +1;
				
		}
		
	
		
		
		
		
		
}
	//hàm xuất dữ liệu ra file 
	
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

