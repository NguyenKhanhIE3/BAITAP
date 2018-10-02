package community.com;

public class DictionaryCommandline {

	public static void showAllWords (Dictionary dtn)
	
	{
		System.out.println("No\t || English \t||Vietnamese");
		for (int id =0 ;id<dtn.getList().size();id++)
		{
			Word word = dtn.getList().get(id);
			System.out.println((id+1) +"\t"+word.getWord_Target()+"\t"+word.getWord_Explain());
			
		}
	}
		public static void dictionaryBasic(Dictionary dtn)
	{
		DictionaryManagement.insertFromCommandline(dtn);
		showAllWords(dtn);
	}
}
