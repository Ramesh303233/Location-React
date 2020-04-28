package udemy.json;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import udemy.json.domain.UdemyStudent;

public class DataBindingWrite {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		UdemyStudent udemyStu = new UdemyStudent();
		udemyStu.setId(1);
		udemyStu.setName("Ramesh");
		udemyStu.setLastname("Kumar");

		UdemyStudent udemyStu2 = new UdemyStudent();
		udemyStu2.setId(1);
		udemyStu2.setName("Sohan");
		udemyStu2.setLastname("Kumar");

		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(udemyStu));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// set value to map

		Map<String, Object> mapJson = new LinkedHashMap<String, Object>();

		mapJson.put("Key1", "value1");
		mapJson.put("key2", "value2");
		mapJson.put("object 1", udemyStu);
		mapJson.put("array", new String[] { "1", "2", "3" });
		mapJson.put("object array", new UdemyStudent[] { udemyStu, udemyStu2 });
		mapJson.put("list", Arrays.asList("3", "4", "5", "6"));

		try {

			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapJson));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/// creating new file to save json data

	 try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src\\main\\resources\\jsondata"), mapJson);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		
		
		
		
	}
}
