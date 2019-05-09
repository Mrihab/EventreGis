package Sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import Depence.Depence;

public class sendSms {


public String sendSms(String msg,long num) {
	
	

	
	try {
		
		
		// Construct data
		String apiKey = "apikey=" + "eqyLTFXTBaw-ZPs6SYkLk19xwVibWZT3YIu1qlgUtX";
		String message = "&message=" + msg;
		String sender = "&sender=" + "Eventr";
                    String numbers = "&numbers=" + "21653960630";
	//	String numbers = "&numbers=" + "00216"+String.valueOf(num);
		
		// Send data
		HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
		String data = apiKey + numbers + message + sender;
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
		conn.getOutputStream().write(data.getBytes("UTF-8"));
		final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		final StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			stringBuffer.append(line);
		}
		rd.close();
		System.out.println("testsms");
		
		return stringBuffer.toString();
	} catch (Exception e) {
		System.out.println("Error SMS "+e);
		return "Error "+e;
		
	}
	
	
	
}}
