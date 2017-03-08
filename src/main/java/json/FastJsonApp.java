package json;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class FastJsonApp {

	public static void readJsonStr() {
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
		Car car = JSON.parseObject(carJson, Car.class);
		System.out.println(car);
	}

	public static void readArray() {
		String carJson = "[{ \"brand\" : \"Mercedes\", \"doors\" : 5 },{ \"brand\" : \"Bench\", \"doors\" : 6 }]";
		List<Car> cars = JSONArray.parseArray(carJson, Car.class);
		for (Car car : cars) {
			System.out.println(car);
		}
	}

	public static void readMap() {
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
		Map<String, Object> map = JSON.parseObject(carJson);
		for (String str : map.keySet()) {
			System.out.println(map.get(str));
		}
	}

	public static void main(String[] args) {
		readMap();
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
