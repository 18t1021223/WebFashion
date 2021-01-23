package com.create.database;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestCreateApplicationTests {

	@Test
	void contextLoads() {
		Map<Integer, Integer> dsMap = new HashMap<Integer, Integer>();
		List<String> ds = null;
		String text = "1,3,1,2,3,1,1";
		String arr[] = text.split("[,]");
		ds = Arrays.asList(arr);
		for (int i = 0; i < ds.size(); i++) {
			int count = 1;
			for (int j = i + 1; j < ds.size(); j++) {

				if (ds.get(i).equals(ds.get(j))) {
					count++;
					ds.remove(j);
					System.out.println(ds);
					j--;
				}
			}

			dsMap.put(Integer.parseInt(ds.get(i)), count);
		}
		System.out.println(ds);
		System.out.println(dsMap);
	}

}
