package HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class urlReader {

	private String[] Routing;
	private HashMap<String, String> DataMap;

	public int RoutingSize;

	public urlReader(InputStream inStream) {

		BufferedReader br = new BufferedReader(new InputStreamReader(inStream));

		try {
			String TopHeader = br.readLine();

			String[] TopHeaderValues = TopHeader.split(" ");

			Routing = TopHeaderValues[1].substring(1).split("/");
			RoutingSize = Routing.length;

			DataMap = new HashMap<String, String>();
			
			if (TopHeaderValues[1].contains("&")) {
				String[] getPara = TopHeaderValues[1].substring(TopHeaderValues[1].indexOf("?") + 1).split("&");

				String[] value;

				for (int i = 0; i < getPara.length; i++) {
					value = getPara[i].split("=");
					System.out.println(value[0] + ", " + value[1]);
					DataMap.put(value[0], value[1]);
				}
			}

//			for (int i=0; i<getPara.length; i++) {
//				System.out.print(i+" "+getPara[i]);
//				System.out.print(" ");
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getRouting(int order) {

		if (Routing[0] == "" || order < 0 || order >= Routing.length) {
			return "";
		}

		return Routing[order];
	}

	public String getData(String key) {
		if (DataMap.containsKey(key)) {
			return DataMap.get(key);
		} else {
			return "";
		}
	}
}
