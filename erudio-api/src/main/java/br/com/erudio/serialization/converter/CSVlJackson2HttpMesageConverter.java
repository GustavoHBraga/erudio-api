package br.com.erudio.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

public class CSVlJackson2HttpMesageConverter extends AbstractJackson2HttpMessageConverter {

	public CSVlJackson2HttpMesageConverter() {
		super( new CsvMapper()
				.setSerializationInclusion(Include.ALWAYS).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES),
				MediaType.parseMediaType("text/csv")
			);
	}
}
