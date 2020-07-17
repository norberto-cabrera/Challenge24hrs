package Framework;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Confi_File {
	@SuppressWarnings("unchecked")
	public String[] ReadFile (){
		JSONParser parser = new JSONParser();
		String[] arreglo = new String[10];
		
		try {
			Object obj = parser.parse(new FileReader("src/main/resources/Data.json"));

			// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
			JSONObject jsonObject = (JSONObject) obj;

			// A JSON array. JSONObject supports java.util.List interface.
			JSONArray List = (JSONArray) jsonObject.get("ConfigList");

			// An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
			// Iterators differ from enumerations in two ways:
			// 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
			// 2. Method names have been improved.
			int i =0;
			Iterator<String> iterator = List.iterator();
			System.out.println("Configuration List: ");
			while (iterator.hasNext()) {
				arreglo[i] = iterator.next();
				System.out.println(arreglo[i]);
                i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arreglo;
	}
}



