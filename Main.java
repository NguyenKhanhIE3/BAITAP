package community.com;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Dictionary dtn = new Dictionary();
		DictionaryCommandline diccom  =new DictionaryCommandline();
		DictionaryManagement dicman=new DictionaryManagement();
	
		//diccom.dictionaryBasic(dtn);
		
		//dicman.removeFromCommandLine(dtn);
		//diccom.dictionarySearcher(dtn);

		diccom.dictionaryAdvanced(dtn);
		//dicman.dictionaryExportToFile(dtn);
		
		
	}

}
