import java.util.Map;
import java.io.*;
public class Tester {
	public static void main(String arg[]) throws FileNotFoundException, UnsupportedEncodingException {
		MainParser webPagePdfExtractor = new MainParser();
		String url = "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf";
        Map<String, Object> extractedMap = webPagePdfExtractor.processRecord(url);
        
        
        if(extractedMap.get("title") != null) {
        	PrintWriter writer = new PrintWriter(extractedMap.get("title")+".txt", "UTF-8");
        	writer.println(url);
        	writer.println(extractedMap.get("title"));
        	writer.println(extractedMap.get("pageCount"));
        	writer.println(extractedMap.get("text"));
        	writer.close();
        }
	}
}
