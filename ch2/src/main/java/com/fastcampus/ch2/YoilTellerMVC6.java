package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC6 {

//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex, BindingResult result) {
//		
//		
//		
//		System.out.println("result = " + result);
//		ex.printStackTrace();
//		return "yoilError";
//	}
	
	
	@RequestMapping("/getYoilMVC6")
//	public String main(@ModelAttribute("myDate") Mydate date, Model model) throws IOException {
	public String main(MyDate date, BindingResult result) throws IOException {
		
		System.out.println("result = " + result);
		

		//1. 유효성 검사
		if (!isValid(date))
			return "yoilError";
		
		// 2. 요일 계산
//		char yoil = getYoil(date);
		
		// 3. 계산한 결과를 model에 저장
//		model.addAttribute("myDate", date);
//		model.addAttribute("yoil", yoil);
		
		return "yoil"; // /WEB-INF/views/yoil.jsp
		
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(int year, int month, int day) {
 		
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}

}
