package community.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {

	DictionaryManagement dict =new DictionaryManagement();
	//hàm hiển thị kết quả danh sách dữ liệu từ điển trên màn hình 
	public  void showAllWords (Dictionary dtn)
	
	{	System.out.println("No    |  English           |     Vietnamese");
		for (int id =0 ;id<dtn.getList().size();id++)
		{
			Word word = dtn.getList().get(id);
			System.out.printf("%-6d|  %-22s|%-2s\n",id+1,word.getWord_Target(),word.getWord_Explain());
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
	Scanner input =new Scanner (System.in);
	do
	{
		System.out.println("============MENU============");
		System.out.println("1.Xoa tu");
		System.out.println("2.Them tu");
		System.out.println("3.Sua tu ");
		System.out.println("4.Tim kiem tu ");
		System.out.println("5.Tim kiem tu bat dau bang  ");
		System.out.println("6.Exit");
		System.out.println("============================");
		System.out.println("Moi ban chon : ");
		int chon = Integer.parseInt (input.nextLine());
		
		switch (chon)
		{
		case 1:
			dict.removeFromCommandLine(dtn);
			break;
		case 2 :
			dict.addWord(dtn);
			break;
		case 3 :
			dict.replaceCommandLine(dtn);
			break;
		case 4 :
			dict.dictionaryLookup(dtn);
			break;
		case 5 :
			dictionarySearcher(dtn);
			break;
		case 6 :
			System.out.println("Thoat menu");
			System.exit(0);
		default :break;
		
			
		}
	}
	while (true );
}
	
		
	
	
//cải tiến 2  
//tìm kiếm từ 
public  void  dictionarySearcher(Dictionary dtn)
{
	System.out.println("Moi ban nhap tu  :");
	String line = new Scanner (System.in).nextLine();
	ArrayList<Word> List = new ArrayList<>();
	List = dtn.getList();
	for (int i =0 ;i<List.size();i++)
	{
		if (List.get(i).getWord_Target().startsWith(line))
			System.out.printf(" %-18s|%s\n",List.get(i).getWord_Target(),List.get(i).getWord_Explain());
	}
	
	
	
}
}