package com.blake.util;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
/**
 * @see �����쳣 Class
 * @author Blake.Zhou
 *
 */
@ControllerAdvice
public class AppwideExceptionHandler {
	/**
	 * @see 500����
	 * @param mv
	 * @return
	 */
	@ExceptionHandler(ConversionNotSupportedException.class)
    public ModelAndView conversionNotSupportedException(ModelAndView mv){
		mv.setViewName("exception/error");
    	return mv;
    }
	/**
	 * @see 404 δ�ҵ����������Դ
	 * @param mv
	 * @return
	 */
	@ExceptionHandler(NoSuchRequestHandlingMethodException.class)
	public ModelAndView noSuchRequestHandlingMethodException(ModelAndView mv){
		mv.setViewName("exception/404");
		return mv;
	}
	
	/**
	 * @see 405
	 * @param mv
	 * @return
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView httpRequestMethodNotSupportedException(ModelAndView mv){
		mv.setViewName("exception/405");
		return mv;
	}
}
