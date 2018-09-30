package community.com;

public class Word {
	private String word_target;//từ mới 
	private String word_explain;//giải nghĩa
	public Word(String word_target , String word_expain)
	{
		//constructor truyền đối số
		this.word_target =word_target;
		this.word_explain = word_explain;
	}
	// phương thức set ,get 
	public void setWord_Target (String word_target)
	{
		this.word_target =this.word_target;
	}
	public void setWord_Explain(String word_explain )
	{
		this.word_explain =this.word_explain;
	}
	public String getWord_Target()
	{
		return this.word_target;
	}
	public String getWord_Explain()
	{
		return this.word_explain;
	}
	
}