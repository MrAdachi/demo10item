package com.zenn.demo10item;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenn.demo10item.dto.ItemResponse;

@SpringBootTest
@AutoConfigureMockMvc
class Demo10itemApplicationTests {
	
	// APIを発行するためのMockオブジェクトのsっ作成
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testGetItemById() throws Exception {
		// 検証するAPIパス
		final String API_PATH = "/item/1";
		
		// JavaのObjectをJSONに変換するためのクラスを生成
		ObjectMapper objectMapper = new ObjectMapper();
		
		// 結果を検証するためのクラスを生成して、期待値をセット
		ItemResponse itemResponse = new ItemResponse();
		itemResponse.setId(1);
		itemResponse.setItemName("大豆");
		
		// APIを実行してレスポンスを検証
		this.mockMvc.perform(MockMvcRequestBuilders.get(API_PATH))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(content().json(objectMapper.writeValueAsString(itemResponse)));
	}

}
