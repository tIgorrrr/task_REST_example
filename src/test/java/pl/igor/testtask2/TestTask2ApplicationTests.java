package pl.igor.testtask2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GeolocationControllerTest {

	@Test
	@WithMockUser(username = "admin")
	void postGeolocation_whenValidDto_saveAndReturnUpdatedDto(@Autowired MockMvc mvc) throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/geolocation").contentType(MediaType.APPLICATION_JSON)
						.content("{\"deviceId\": \"testId\", \"latitude\": 11, \"longitude\": 12}"))
				.andExpect(status().isOk());
	}

	public static Stream<String> getWrongJsons() {
		return Stream.of(
				"{\"deviceId\": 10, \"latitude\": \"latitudewrong\", \"longitude\": 12}",
				"{\"deviceId\": \"testId\", \"latitudeWrongname\": 11, \"longitude\": 12}",
				"{\"deviceId\": \"testId\", \"latitude\": 11, \"longitudeWrongname\": 12}",
				"{\"deviceIdWrongname\": \"ajhsdbjashdbjsa\", \"latitude\": 11, \"longitude\": 12}",
				" \"latitude\": 11, \"longitude\": 12}",
				"{\"deviceId\": \"ajhsdbjashdbjsa\", \"longitude\": 12}",
				"{\"deviceId\": \"ajhsdbjashdbjsa\", \"latitude\": 11}"
		);
	}

	@Autowired
	MockMvc mvc;

	@ParameterizedTest
	@MethodSource("getWrongJsons")
	@WithMockUser(username = "admin")
	void postGeolocation_whenInvalidDto_ReturnBadRequest(String testBody) throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/geolocation").contentType(MediaType.APPLICATION_JSON)
						.content(testBody))
				.andExpect(status().isBadRequest());
	}
}
