package dev.lhphong.bankapi.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    String value;
    public HttpUtil(String value) {
        this.value = value;
    }
    public <T> T convertTo(Class<T> tClass) throws IOException {
        return new ObjectMapper().readValue(value.getBytes(),tClass);
    }

    public static HttpUtil of(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null)
            sb.append(line);
        return new HttpUtil(sb.toString());
    }
}
