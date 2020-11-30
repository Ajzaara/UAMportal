package com.nokia.application.ossuamws.shared.utility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nokia.application.ossuamws.repository.UserRepository;

@Component
public class Utils {
	@Autowired
	UserRepository userRepository;

	public String generateUserName(String firstName, String lastName) {

		String username = getUsername(firstName, lastName);
		while (userRepository.findByUserName(username) != null) {
			username = getUsername(firstName, lastName);
		}
		return username;
	}

	private String getUsername(String firstName, String lastName) {

		Random random = new Random();

		int min = 1;
		int max = 10;

		int randomInt1 = random.nextInt((max - min) + 1) + min;
		int randomInt2 = random.nextInt((max - min) + 1) + min;
		int randomInt3 = random.nextInt((max - min) + 1) + min;

		String randomNumCombination = "" + randomInt1 + randomInt2 + randomInt3;

		return lastName + "." + firstName + randomNumCombination;

	}

	public String generateLoginId() {

		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return generatedString;
	}
	
	public Optional<String> getExtensionByStringHandling(String filename) {
		return Optional.ofNullable(filename).filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
	
	public String getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		sdf.setTimeZone(TimeZone.getDefault());
		
		return sdf.format(calendar.getTime());
	}
	
	public LocalDateTime getCurrentLocalDateTime() {
	LocalDateTime lt= LocalDateTime.now(); 
	System.out.println(lt);
	return lt;
	}

	public LocalDateTime getExpiryDate() {	
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.YEAR, 1); // to get previous year add -1
	Date nextYear = cal.getTime();
	return convertToLocalDateTimeViaInstant(nextYear);
	}
	
	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
//	Date convertToDateViaInstant(LocalDateTime dateToConvert) {
//	    return java.util.Date
//	      .from(dateToConvert.atZone(ZoneId.systemDefault())
//	      .toInstant());
//	}
}
