<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<title>Primes</title>
<jsp:include page="../../tags/coreDependencies.jsp" />
<link rel="stylesheet" type="text/css" href="/css/custom/math.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/math/crypto.css" />
<script type="text/javascript" src="/javascript/custom/crypto.js"></script>
</head>
<body>
	<jsp:include page="../../tags/navbar.jsp" />
	<jsp:include page="../../tags/header.jsp" />
	
	<div id="wrapper" class="blue">
		<jsp:include page="../../tags/mathHeader.jsp"></jsp:include>
		<div class="info">
			<div id="mathIntro">
				<p>
					This is my cryptography page; it's one of my favorite subjects considering
					my math and computer background.  I took a Math-oriented class in cryptography
					in college where we learned how to implement and beat some of the more basic
					algorithms, and ever since then encrypting and decrypting information has been 
					a great interest of mine.
				</p>
				<p>
					And thus I designed this page.  It features a handful of cryptographyic algorithms
					that you can use to encrypt data on demand.  You can either supply an encryption key
					(you'll have to be sure it is an appropriate Base64-encoded key for the algorithm),
					or I'll generate one for you if you leave that field blank.  Either way put some
					text in the 'value' field and encrypt away!  I'll populate the encryption key field 
					if you don't.  Similarly feel free to use the decryption form to decrypt 
					some encrypted data.  I'll use the same encryption key field mentioned above
					to decrypt (so you can enter your own or use my generated one).  Obviously all values
					are Base64 encoded so you can copy and paste them, as well as see them.
				</p>
			</div>
		</div>
		<div class="info">
			<form name="rc4">
				<table id="rc4" class="center crypto">
					<tr>
						<th class="titleWrapper" colspan="2">
							<h3>
								RC4
							</h3>
						</th>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label for="encryptvalue">
									Value To Encrypt
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<input type="text" name="encryptvalue" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label for="encryptionKey">
									Encryption Key
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<input type="text" name="encryptionKey" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="cellWrapper" colspan="2">
							<div>
								<button class="button encrypt">Encrypt</button>
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label>
									Encrypted Value
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<div id="encrypt" class="result"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label for="decryptvalue">
									Value To Decrypt
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<input type="text" name="decryptvalue" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="cellWrapper" colspan="2">
							<div>
								<button class="button decrypt">Decrypt</button>
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label>
									Decrypted Value
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<div id="decrypt" class="result"></div>
							</div>
						</td>
					</tr>
				</table>
			</form>
			<form name="tripleDES">
				<table id="tripleDES" class="center crypto">
					<tr>
						<th class="titleWrapper" colspan="2">
							<h3>
								Triple DES
							</h3>
						</th>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label for="encryptvalue">
									Value To Encrypt
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<input type="text" name="encryptvalue" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label for="encryptionKey">
									Encryption Key
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<input type="text" name="encryptionKey" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="cellWrapper" colspan="2">
							<div>
								<button class="button encrypt">Encrypt</button>
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label>
									Encrypted Value
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<div id="encrypt" class="result"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label for="decryptvalue">
									Value To Decrypt
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<input type="text" name="decryptvalue" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="cellWrapper" colspan="2">
							<div>
								<button class="button decrypt">Decrypt</button>
							</div>
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="orange label">
								<label>
									Decrypted Value
								</label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<div id="decrypt" class="result"></div>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<jsp:include page="../../tags/navigation.jsp" />
</body>
</html>