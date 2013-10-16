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
			if(Utility.nullOrEmpty(wrapper.getEncryptionKey())) {
				wrapper.setEncryptionKey(RC4.generateKey())
			}
			
			String result = "Error";
			if(CryptoMethod.ENCRYPT.value().equalsIgnoreCase(wrapper.getMethod().value)) {
				result = RC4.encryptAndEncode(wrapper.getValue(), wrapper.getEncryptionKey());
			} else {
				result = RC4.decodeAndDecrypt(wrapper.getValue(), wrapper.getEncryptionKey());
			}
			
			response.put("success", true);
			response.put("result", result);
			response.put("encryptionKey", wrapper.getEncryptionKey());
		} catch(CryptoException e) {
			log.error("Error performinging RC4 "+wrapper.getMethod(), e);
			response.put("success", false);
		}
		
		return response.toString();
	}
	
	@RequestMapping(value = [ "tripleDES" ], method = [ RequestMethod.POST ], produces = [ "application/json" ])
	@ResponseBody
	public String tripleDES(@ModelAttribute EncryptWrapper wrapper) {
		JSONObject response = new JSONObject();
		
		try {
			if(Utility.nullOrEmpty(wrapper.getEncryptionKey())) {
				wrapper.setEncryptionKey(TripleDES.generateKey())
			}
			
			String result = "Error";
			if(CryptoMethod.ENCRYPT.value().equalsIgnoreCase(wrapper.getMethod().value)) {
				result = TripleDES.encryptAndEncode(wrapper.getValue(), wrapper.getEncryptionKey());
			} else {
				result = TripleDES.decodeAndDecrypt(wrapper.getValue(), wrapper.getEncryptionKey());
			}
			
			response.put("success", true);
			response.put("result", result);
			response.put("encryptionKey", wrapper.getEncryptionKey());
		} catch(CryptoException e) {
			log.error("Error performinging TripleDES "+wrapper.getMethod(), e);
			response.put("success", false);
		}
		
		return response.toString();
	}
		
}
