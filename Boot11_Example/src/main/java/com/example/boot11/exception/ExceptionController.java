package com.example.boot11.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//예외 컨트롤러는 @ControllerAdvice 어노테이션을 붙여서 bean 으로 만든다.
@ControllerAdvice
public class ExceptionController {
	/*
	 *	스프링 프레임워크가 동작하는 중에 PasswordException type 의 예외가 발생하면 이 메소드가 자동 호출된다.
	 *	매개 변수에는 해당 예외객체의 참조값이  전달된다.
	 *	일반 컨트롤러 처럼 필요한 객체를 매개변수에 선언하면 스프링이 알아서 전달해 준다.
	 *	템플릿 페이지로 forward 이동해서 응답할수도 있고 리다일렉트 응답할 수도 있다.
	 */
//	@ExceptionHandler(PasswordException.class)
//	public String password(PasswordException pe, Model model) {
//		/*
//		 *	"exception" 이라는 키값으로 예외 객체를 담으면
//		 *	템플릿 페이지에서 예외 객체는 ${exception} 으로 참조할수 있고
//		 *	예외 메세지는 ${exception.message} 로 읽어낼수가 있다.
//		 *	.message 는 getter 메소드 즉 .getMessage() 를 호출하는 것이다. 
//		 */
//		model.addAttribute("exception", pe);
//		// /templates/error/password.html 템플릿 페이지로 응답하기
//		return "error/password";
//	}
	
	/*
	 *	RedirectAttribute 객체를 이용하면 리다일렉트 이동된 페이지에 데이터를 전달 해줄수도 있다. 
	 */
	@ExceptionHandler(PasswordException.class)
	public String password(PasswordException pe, RedirectAttributes ra) {
		
		// 리다일렉트 이동된 페이지에서도 한번 사용할수 있다. 
		// Thymeleaf 에서 ${exception} 으로 참조 가능
		ra.addFlashAttribute("exception", pe);
		
		// /user/pwd_updateform 로 요청을 다시 하라고 리다일렉트 응답하기
		return "redirect:/user/pwd_updateform";
	}

	@ExceptionHandler(NotOwnerException.class)
	public String notOwner(NotOwnerException noe, Model model) {
		// "exception" 이라는 키값으로 예외 객체를 담는다.
		model.addAttribute("exception", noe);
		
		//view 페이지에서 에러 정보를 응답한다.
		return "error/info";
	}

}
