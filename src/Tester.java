import java.util.Map;

public class Tester {
	public static void main(String arg[]) {
		MainParser webPagePdfExtractor = new MainParser();
        Map<String, Object> extractedMap = webPagePdfExtractor.processRecord("http://www.snee.com/xml/xslt/sample.doc");
        System.out.println(extractedMap.get("text"));
	}
}
