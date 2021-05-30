package br.com.digitalhouse.restaurantapi.dataprovider.repository.impl.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface FileUtils {

	public static <T> List<T> getContentListOf(File file, TypeReference<List<T>> typeRef) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.readValue(file, typeRef);
	}
	
	public static <T> T getContentOf(File file, TypeReference<T> typeRef) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.readValue(file, typeRef);
	}
	
	public static void writeFile(File file, String json) throws IOException {
		FileWriter fileWrite = new FileWriter(file, false);
		fileWrite.write(json);
		fileWrite.flush();
		fileWrite.close();
	}

}
