import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

@SuppressWarnings("deprecation")
public class MainParser {
	public Map<String, Object> processRecord(String url){
		@SuppressWarnings("resource")
		DefaultHttpClient client = new DefaultHttpClient();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HttpGet Gethttp = new HttpGet(url);
			HttpResponse res = client.execute(Gethttp);
			HttpEntity entity = res.getEntity();
			InputStream input = null;
			if(entity != null) {
				try {
					input = entity.getContent();
					BodyContentHandler handler = new BodyContentHandler();
					Metadata meta = new Metadata();
					AutoDetectParser parser = new AutoDetectParser();
					ParseContext context = new ParseContext();
					parser.parse(input, handler, meta, context);
					map.put("text", handler.toString().replaceAll("\n|\r|\t", " "));
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					if(input != null) {
						try {
							input.close();
						} catch(IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}
}
