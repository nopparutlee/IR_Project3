import java.util.List;

public class Document implements Comparable
{
	private Integer id = -1;	//document/query ID
	private String rawText = null;	//raw text from the file
	private List<String> tokens = null;	//tokens after preprocessing raw text
	private String url = null;	//url of the document
	public int getId() {
		return id;
	}
	public Document(Integer id, String rawText, List<String> tokens) {
		this.id = id;
		this.rawText = rawText;
		this.tokens = tokens;
	}
	public Document(Integer id, String rawText, List<String> tokens, String url) {
		this.id = id;
		this.rawText = rawText;
		this.tokens = tokens;
		this.url = url;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRawText() {
		return rawText;
	}
	public void setRawText(String rawText) {
		this.rawText = rawText;
	}
	public List<String> getTokens() {
		return tokens;
	}
	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}
	public String getUrl(){
		return url;
	}
	public void setUrl(String url){
		this.url = url;
	}
	
	public String toString()
	{
		return "[ID:"+this.id+", "+(this.rawText.length() > 50? this.rawText.substring(0, 50)+"...":this.rawText)+"]\nurl:"+url;
	}
	
	@Override
	public int compareTo(Object arg0) {
		Document other = (Document)arg0;
		if(this.id == other.id && this.rawText != null && other.rawText != null) return this.rawText.compareTo(other.rawText);
		return this.id - other.id;
	}
}
