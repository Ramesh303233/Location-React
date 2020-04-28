package udemy.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.*;

import com.fasterxml.jackson.core.type.TypeReference;
import udemy.json.domain.UdemyStudent;

public class DataBindingRead {

	public static void main(String[] args) {

		String udemyStudentJson = "{" + "  \"id\" : 1," + "  \"name\" : \"Ramesh\"," + "  \"lastname\" : \"Kumar\""
				+ "}";

		ObjectMapper mapper = new ObjectMapper();

		
		try {
			
			  Map<String, Object> mapJson = mapper.readValue(new File("C:\\Users\\Lenovo\\Desktop\\jsondata"), new TypeReference<Map<String,Object>>() { } );
			 System.out.println(mapJson);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
