package json;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonApp {

	public static void databind() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
			Car car = objectMapper.readValue(carJson, Car.class);
			System.out.println("car.brand = " + car.brand);
			System.out.println("car.doors = " + car.doors);

			JsonNode node = objectMapper.readValue(carJson, JsonNode.class);
			Iterator<JsonNode> it = node.iterator();
			while (it.hasNext()) {
				System.out.println(it.next().asText());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void treeModel() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5,"
					+ "  \"owners\" : [\"John\", \"Jack\", \"Jill\"],"
					+ "  \"nestedObject\" : { \"field\" : \"value\" } }";
			JsonNode node = objectMapper.readValue(carJson, JsonNode.class);

			JsonNode brandNode = node.get("brand");
			String brand = brandNode.asText();
			System.out.println("brand = " + brand);

			JsonNode doorsNode = node.get("doors");
			int doors = doorsNode.asInt();
			System.out.println("doors = " + doors);

			JsonNode array = node.get("owners");
			JsonNode jsonNode = array.get(0);
			String john = jsonNode.asText();
			System.out.println("john  = " + john);

			JsonNode child = node.get("nestedObject");
			JsonNode childField = child.get("field");
			String field = childField.asText();
			System.out.println("field = " + field);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void GenerateJSONStr() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Car car = new Car();
			car.brand = "BMW";
			car.doors = 4;

			String json = objectMapper.writeValueAsString(car);
			System.out.println(json);
		} catch (Exception e) {
		}
	}

	public static void readJosnStr() throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		// 1.Reading JSON From a String

		// 2.Reading JSON From a Reader
		// String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 4 }";
		// Reader reader = new StringReader(carJson);
		// Car car = objectMapper.readValue(reader, Car.class);

		// 3.Reading JSON From a File
		// File file = new File("src/main/java/json/car.json");
		// Car car = objectMapper.readValue(file, Car.class);

		// 4.Reading JSON From a URL
		URL url = new URL("file:src/main/java/json/car.json");
		Car car = objectMapper.readValue(url, Car.class);

		// 5.Reading JSON From an InputStream
		// 6.Reading JSON From a Byte Array

		System.out.println(car);
	}

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		readJosnStr();
	}

	private static class Car {
		public String brand;
		public int doors;

		@Override
		public String toString() {
			return "Car [brand=" + brand + ", doors=" + doors + "]";
		}

	}

}
