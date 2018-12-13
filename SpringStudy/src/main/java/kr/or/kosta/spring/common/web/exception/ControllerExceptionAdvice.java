package kr.or.kosta.spring.common.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
@ControllerAdvice("kr.or.kosta.spring.employee.controller") //이 패키지에 해당하는 객체들에 대한 예외처리
public class ControllerExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView commonExceptionHandle(Exception exception) {
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("error/error_500");
         modelAndView.addObject("exception", exception);
         return modelAndView;
    }

}
