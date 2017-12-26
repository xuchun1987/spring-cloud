package cloud.aop;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = Logger.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleExp( Exception ex){
        logger.error("----------------------Business exception handler：  " + ex.getMessage() );
       return "系统异常Gobal";
    }


    /*@ExceptionHandler(SQLException.class)
    public ModelAndView handSql(Exception ex){
        LOG.info("SQL Exception " + ex.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", ex.getMessage());
        mv.setViewName("sql_error");
        return mv;
    }*/
}
