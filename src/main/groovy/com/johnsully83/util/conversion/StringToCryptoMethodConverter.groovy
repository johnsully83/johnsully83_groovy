package com.johnsully83.util.conversion

import org.springframework.core.convert.converter.Converter

import com.johnsully83.model.enumeration.crypto.CryptoMethod

class StringToCryptoMethodConverter implements Converter<String, CryptoMethod> {

	@Override
	CryptoMethod convert(String source) {
		CryptoMethod.value(source);
	}

}
