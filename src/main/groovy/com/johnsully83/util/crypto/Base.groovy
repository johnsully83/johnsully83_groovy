package com.johnsully83.util.crypto

import java.nio.charset.Charset

import org.apache.commons.codec.binary.Base64
import org.apache.commons.codec.binary.StringUtils

import com.google.common.base.Charsets

abstract class Base {
	
	protected static byte[] base64Decode(String encrypedAndEncoded) {
		return Base64.decodeBase64(encrypedAndEncoded);
	}

	protected static String base64Encode(byte[] value) {
		return StringUtils.newStringUtf8(Base64.encodeBase64(value));
	}
	
	protected static final String TRIPLE_DES_TRANSFORMATION = "DESede/ECB/PKCS7Padding";
	protected static final String TRIPLE_DES_ALGORITHM = "DESede";
	
	protected static final String RC4_ALGORITHM = "ARCFOUR";
	
	protected static final String BOUNCY_CASTLE_PROVIDER = "BC";
	
	protected static final Charset CHARSET = Charsets.UTF_8;
	
}
