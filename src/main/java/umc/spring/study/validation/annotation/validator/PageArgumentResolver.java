package umc.spring.study.validation.annotation.validator;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.GeneralException;
import umc.spring.study.validation.annotation.PageError;

@Component
public class PageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageError.class) &&
                (parameter.getParameterType().equals(Integer.class) || parameter.getParameterType().equals(int.class));
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {




        String pageStr = webRequest.getParameter("page");

        int page;
        try {
            page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
        } catch (NumberFormatException e) {
            throw new GeneralException(ErrorStatus.PAGE_LESS_THAN_ONE);
        }

        if (page < 1) {

            throw new GeneralException(ErrorStatus.PAGE_LESS_THAN_ONE);
        }

        return page - 1;
    }
}