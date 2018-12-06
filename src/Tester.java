import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.lang.reflect.Array;
public class Tester {
	public static void main(String arg[]) throws FileNotFoundException, UnsupportedEncodingException {
		MainParser webPagePdfExtractor = new MainParser();
		//String url = "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf";
        List<String> urls = (List<String>) Arrays.asList(//"http://www.alternativeeducation.or.th/download/184/",
        		"http://www.alternativeeducation.or.th/download/199/",
        		"http://www.alternativeeducation.or.th/download/201/",
        		"http://www.alternativeeducation.or.th/download/203/",
        		"http://www.alternativeeducation.or.th/download/205/",
        		"http://www.alternativeeducation.or.th/download/207/",
        		"http://www.alternativeeducation.or.th/download/209/",
        		"http://www.alternativeeducation.or.th/download/317/",
        		"http://www.alternativeeducation.or.th/download/212/",
        		"http://www.alternativeeducation.or.th/download/214/",
        		"http://www.alternativeeducation.or.th/download/216/",
        		"http://www.alternativeeducation.or.th/download/218/",
        		"http://www.alternativeeducation.or.th/download/270/",
        		"http://www.alternativeeducation.or.th/download/273/",
        		"http://www.alternativeeducation.or.th/download/276/"
        		);
        for(String url:urls){
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
}
