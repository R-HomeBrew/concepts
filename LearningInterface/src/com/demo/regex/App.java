package com.demo.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.security.auth.login.CredentialException;





public class App {

	private static String aws = "aws.MyAccountID=647261884237\n"+
			"aws.accessId=AKIAZNM6QR5GUW44XXFJ\n"+
			"aws.secretKey=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\n"+
			"aws.keyPair_eu-west-1=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.keyPair_EU=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.forceGP2=true\n";
	
	
	private static String nfs = "aws.MyAccountID=647261884237\n"+
			"key.xys.accessId=AKIAZNM6QR5GUW44XXFJ\n"+
			"nfs.secretKey=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\n"+
			"aws.keyPair_eu-west-1=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.keyPair_EU=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.forceGP2=true\n";
	
	
	private static String dfs = "aws.MyAccountID=647261884237\n"+
			"AKIAZNM6QR5GUW44XXFJ\n"+
			"nfs.secretKey=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\n"+
			"aws.keyPair_eu-west-1=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.keyPair_EU=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.forceGP2=true\n";
	

	private static String kfs = "aws.MyAccountID=647261884237\n"+
			"aws.accessId=\n"+
			"aws.secretKey=\n"+
			"aws.keyPair_eu-west-1=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.keyPair_EU=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.forceGP2=true\n";
	
	
	private static String privatekey = " -----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEpAIBAAKCAQEArBp9yMkdH/fN6M+memeYAcDeo059ils3YmHzei9fFtRgqqjH\n"
			+ "qAiXICuGZymaCHcZtxOei99GB00qIEFfjpa+N5LNyh6JimDVCr1ZxEhtG/zwyIGq\n"
			+ "Mgt2v7DErFVCj0DViF2+sw+4aK2y0ylAC7Tph+Mpq6Yl+YJTb/kw1tn/M3CTlAm2\n"
			+ "abDxfxZa4osmWNCQrACv5BSe\n";
	
	
	private static String config = "apiVersion: v1\n"
			+ "clusters:\n"
			+ "- cluster:\n"
			+ "    insecure-skip-tls-verify: true\n"
			+ "    server: https://euw1-cntstg-cntfrm.3dx-staging.3ds.com:443/\n"
			+ "  name: https://euw1-cntstg-cntfrm.3dx-staging.3ds.com:443/\n"
			+ "contexts:\n"
			+ "- context:\n"
			+ "    cluster: https://euw1-cntstg-cn  was: apiVersion: v1\n"
			+ "clusters:\n"
			+ "- cluster:\n"
			+ "    insecure-skip-tls-verify: true\n"
			+ "    server: https://eu2-cntstg-cntfrm.3dx-staging.3ds.com:443/\n"
			+ "  name: https://eu2-cntstg-cntfrm.3dx-staging.3ds.com:443/\n"
			+ "contexts:\n"
			+ "- context:\n"
			+ "    cluster: https://eu2-cntstg-cntfr\n"
			+ "Credentials: aws.MyAccountID=647261884237\n"
			+ "aws.keyPair_eu-west-1=AWS-PRDPR0011-EU-WEST-1\n"
			+ "aws.keyPair_EU=AWS-PRDPR0011-EU-WEST-1\n"
			+ "aws.forceGP2=true\n"
			+ "\n"
			+ "";
	
	private static String hce = "aws.MyAccountID=647261884237\n"+
			"aws.access_key=AKIAZNM6QR5GUW44XXFJ\n"+
			"aws.secret_key=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\n"+
			"aws.keyPair_eu-west-1=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.keyPair_EU=AWS-PRDPR0011-EU-WEST-1\n"+
			"aws.forceGP2=true\n";
	
	private static String EOL = "\n";//System.lineSeparator();
	//private static String ACCESSKEY = ".accessId=";
	//private static String SECRETKEY = ".secretKey=";
	
	private static String ACCESSKEY = ".access";
	private static String SECRETKEY = ".secret";
	
	private static Pattern akPattern = Pattern.compile(ACCESSKEY);
	private static Pattern skPattern = Pattern.compile(SECRETKEY);

	private static int STARTENDMASKLENGTH = 3;
	
	
	public static String maskCredentials(String creds) {
		
		Optional<String> optCreds = Optional.ofNullable(creds);
		List<String> maskedCreds = new ArrayList<String>();
		
		if(optCreds.isPresent()) {
			
			boolean doAKSKMarsking = (akPattern.matcher(optCreds.get()).find() || skPattern.matcher(optCreds.get()).find());
			
			System.out.println(akPattern.matcher(optCreds.get()).find() );
			System.out.println(skPattern.matcher(optCreds.get()).find() );
			if(doAKSKMarsking) {
				
				List<Optional<String>> credentials =  optCreds.
						filter(opt -> !opt.isEmpty())
						.map(opt -> {
									return Arrays.asList(opt.split(EOL)).stream().
											map(keyValue -> Optional.ofNullable(keyValue)).
											collect(Collectors.toList());
						}).orElse(new ArrayList<Optional<String>>());
				
				maskedCreds = credentials.stream().map(opt -> { 
					String cred = opt.orElse("");
					cred = maskIfMatches(cred, akPattern);
					cred = maskIfMatches(cred, skPattern);
					return cred;
				}).collect(Collectors.toList());
				
				String result = maskedCreds.stream().collect(Collectors.joining("\n"));
				
				maskedCreds.forEach(str -> {
					System.out.println("Masked VALUE "+str);
				});
				
				System.out.println("Result \n"+result);
			} else {
				// generic Masking
				boolean maskStartAndEnd = false;
				String result = doMasking(optCreds.get(), maskStartAndEnd);
				System.out.println("Result \n"+result);
			}
			 
			
			
			
		}
		
		return creds;
	}
	
	
	
	private static String maskIfMatches(String value, Pattern pattern) {
		String maskedValue = value;
		try {
			Matcher matcher = pattern.matcher(value);
			if (matcher.find()) {
				String key =  matcher.group();
				int seperator = value.indexOf("=");
				Optional<String> valueOpt = Optional.ofNullable(value.substring(seperator+1));
				System.out.println("Value Romil "+valueOpt.get());
				Optional<String> keyOpt = Optional.ofNullable(value.substring(0, seperator));
				if(valueOpt.isPresent()) {
					String str = valueOpt.orElse("");
					boolean maskStartAndEnd = true;
					maskedValue = String.format(keyOpt.orElse("UNKNOWN")+"=%s", doMasking(str, maskStartAndEnd));
				}
			}
		} catch (Exception e) {
		} 
		return maskedValue;
	}
	
	
	
	private static String doMasking(String str, boolean maskStartAndEnd) {
		String maskedString = str;
		
		if(maskStartAndEnd && (str.length() > STARTENDMASKLENGTH * 2)) {
			char [] chars = str.toCharArray();
			int pre = 2;
			int post = chars.length - 3; //8
			for(int i = 0; i < chars.length; i++) {
				
				if(i > pre && i < post) {
					chars[i] = '*';
				}
			}
			maskedString = new String(chars);
		} else if(!maskStartAndEnd) {
			char [] chars = str.toCharArray();
			int maskCount = 0;
			for(int i = (chars.length - 1); i >= 0; i--) {
				if(maskCount < chars.length/2 && chars[i] != '\n' ) {
					chars[i] = '*';
					maskCount++;
				}
			}
			maskedString = new String(chars);
		}
		return maskedString;
	}
	
	public static void main(String[] args) {
		
		String returnValue = "";
		
		
		
		Optional<String> awsOptional = Optional.ofNullable(aws);
		
		if(awsOptional.isEmpty()) returnValue = "";
		
		maskCredentials(config);
		
		//maskCredentials(nfs);
		
		//maskCredentials(dfs);
		
		//maskCredentials(dfs);
		
		//maskCredentials(privatekey);
		
		//maskCredentials(config);
		
	
		
	}

	
}
