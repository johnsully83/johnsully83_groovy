package com.johnsully83.util.conversion

import org.springframework.core.convert.converter.Converter

import com.johnsully83.model.enumeration.crypto.CryptoMethod

class CryptoMethodToStringConverter implements Converter<CryptoMethod, String> {

	@Override
	String convert(CryptoMethod source) {
		source.value;
	}

}
