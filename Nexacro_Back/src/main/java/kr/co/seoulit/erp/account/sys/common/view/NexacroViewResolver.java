package kr.co.seoulit.erp.account.sys.common.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class NexacroViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        System.out.println("nexacroviewResolver 실행");
        return (map, httpServletRequest, httpServletResponse) -> {};
    }
}
