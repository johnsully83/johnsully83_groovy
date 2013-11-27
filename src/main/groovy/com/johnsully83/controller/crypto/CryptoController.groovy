package com.johnsully83.controller.crypto

import org.apache.log4j.Logger
import org.json.JSONObject
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import com.johnsully83.exception.crypto.CryptoException
import com.johnsully83.model.enumeration.crypto.CryptoMethod
import com.johnsully83.model.wrapper.mvc.crypto.EncryptWrapper
import com.johnsully83.util.crypto.implementations.RC4
import com.johnsully83.util.crypto.implementations.TripleDES
import com.johnsully83.utility.Utility

@Controller
@RequestMapping(value = [ "/crypto/*" ])
class CryptoController {
	
	private final Logger log = Logger.getLogger(CryptoController.class);
	
	@RequestMapping(value = [ "rc4" ], method = [ RequestMethod.POST ], produces = [ "application/json" ])
	@ResponseBody
	public String rc4(@ModelAttribute EncryptWrapper wrapper) {
		JSONObject response = new JSONObject();
		
		try {
			if(!wrapper.encryptionKey) {
				wrapper.encryptionKey = RC4.generateKey()
			}
			
			def result = "Error";
			if(CryptoMethod.ENCRYPT.value().equalsIgnoreCase(wrapper.method.value)) {
				result = RC4.encryptAndEncode(wrapper.value, wrapper.encryptionKey);
			} else {
				result = RC4.decodeAndDecrypt(wrapper.value, wrapper.encryptionKey);
			}
			
			response.put("success", true);
			response.put("result", result);
			response.put("encryptionKey", wrapper.encryptionKey);
		} catch(CryptoException e) {
			log.error("Error performinging RC4 "+wrapper.method, e);
			response.put("success", false);
		}
		
		return response.toString();
	}
	
	@RequestMapping(value = [ "tripleDES" ], method = [ RequestMethod.POST ], produces = [ "application/json" ])
	@ResponseBody
	public String tripleDES(@ModelAttribute EncryptWrapper wrapper) {
		JSONObject response = new JSONObject();
		
		try {
			if(!wrapper.encryptionKey) {
				wrapper.encryptionKey = RC4.generateKey()
			}
			
			def result = "Error";
			if(CryptoMethod.ENCRYPT.value().equalsIgnoreCase(wrapper.method.value)) {
				result = TripleDES.encryptAndEncode(wrapper.value, wrapper.encryptionKey);
			} else {
				result = TripleDES.decodeAndDecrypt(wrapper.value, wrapper.encryptionKey);
			}
			
			response.put("success", true);
			response.put("result", result);
			response.put("encryptionKey", wrapper.encryptionKey);
		} catch(CryptoException e) {
			log.error("Error performinging TripleDES "+wrapper.method, e);
			response.put("success", false);
		}
		
		return response.toString();
	}
		
}
