package com.jnh.pagemarkers.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jnh.core.services.errors.dto.ErrorDefinition;
import com.jnh.pagemarkers.api.dto.GenericResponse;
import com.jnh.pagemarkers.api.exceptions.ParameterNotFoundException;

/**
 * Base Controller.
 */
@Controller
public class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    /**
     * Null constructor. Security AOP reason.
     */
    public BaseController() {
    }

    /**
     * @param ex
     * @param response
     * @return
     */
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    @ResponseBody
    public GenericResponse handleException(MethodArgumentNotValidException ex, HttpServletResponse response) {
        BindingResult bindingResult = ex.getBindingResult();
        String errorCode = "";
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            if (objectErrors.size() > 0) {
                ObjectError objectError = objectErrors.get(0);
                errorCode = objectError.getCode();
            }
        }
//        ErrorDefinition error = errorService.resolvePolicy(ex);
        ErrorDefinition error = new ErrorDefinition();
        response.setStatus(Integer.parseInt(error.getHttpStatusCode()));
        GenericResponse genericResponse = new GenericResponse(error.getErrorId().getId(), error.getErrorId()
                .getCategory(), error.getName(), errorCode);

        BaseController.LOGGER.error(ex.toString() + ": " + genericResponse.toString());
        BaseController.LOGGER.debug(ex.toString() + ": " + genericResponse.toString(), ex);

        return genericResponse;
    }

//    /**
//     * Handler WalletExternalException.
//     * 
//     * @param ex
//     * @param response
//     * @return
//     */
//    @ExceptionHandler(value = { WalletExternalException.class })
//    @ResponseBody
//    public GenericResponse handleException(WalletExternalException ex, HttpServletResponse response) {
//        ErrorDefinition error = errorService.resolve(ex);
//        response.setStatus(Integer.parseInt(error.getHttpStatusCode()));
//        GenericResponse genericResponse = new GenericResponse(error.getErrorId().getId(), error.getErrorId()
//                .getCategory(), error.getName(), error.getTxt());
//
//        BaseController.LOGGER.error(ex.toString());
//        BaseController.LOGGER.debug(ex.toString() + ": ", ex);
//
//        return genericResponse;
//    }
//
//    /**
//     * Handler SessionId Exceptions.
//     * 
//     * @param ex
//     * @param response
//     * @return
//     */
//    @ExceptionHandler(value = { SessionIdException.class })
//    @ResponseBody
//    public GenericResponse handleException(SessionIdException ex, HttpServletResponse response) {
//        ErrorDefinition error = errorService.resolve(ex.getCategory(), ex.getId());
//        response.setStatus(Integer.parseInt(error.getHttpStatusCode()));
//        GenericResponse genericResponse = new GenericResponse(error.getErrorId().getId(), error.getErrorId()
//                .getCategory(), error.getName(), error.getTxt());
//
//        BaseController.LOGGER.error(ex.toString());
//        BaseController.LOGGER.debug(ex.toString() + ": ", ex);
//
//        return genericResponse;
//    }
//
    /**
     * Handler Wallet Exceptions.
     * 
     * @param ex
     * @param response
     * @return
     */
    @ExceptionHandler(value = { Exception.class })
    @ResponseBody
    public GenericResponse handleException(Exception ex, HttpServletResponse response) {
    	ErrorDefinition error = new ErrorDefinition();
        int status = Integer.parseInt(error.getHttpStatusCode());
        if (status == 401) {
            response.setHeader("WWW-Authenticate", "Basic realm=\"Wallet Restricted Area\"");
        }

        response.setStatus(status);
        GenericResponse genericResponse = new GenericResponse(error.getErrorId().getId(), error.getErrorId()
                .getCategory(), error.getName(), ex.getMessage());
        BaseController.LOGGER.error(ex.toString());
        BaseController.LOGGER.debug(ex.toString() + ": ", ex);

        return genericResponse;
    }
//
//    /**
//     * Handler Wallet Throwable Exceptions.
//     * 
//     * @param ex
//     * @param response
//     * @return
//     */
//    @ExceptionHandler(value = { Throwable.class })
//    @ResponseBody
//    public GenericResponse handleException(Throwable ex, HttpServletResponse response) {
//        ErrorDefinition error = errorService.resolve("SVR", "1000");
//        int status = Integer.parseInt(error.getHttpStatusCode());
//        if (status == 401) {
//            response.setHeader("WWW-Authenticate", "Basic realm=\"Wallet Restricted Area\"");
//        }
//
//        response.setStatus(status);
//        GenericResponse genericResponse = new GenericResponse(error.getErrorId().getId(), error.getErrorId()
//                .getCategory(), error.getName(), "System ERROR");
//
//        BaseController.LOGGER.error(ex.toString() + ": ");
//
//        return genericResponse;
//    }

    /**
     * Check a Json body against a class.
     * 
     * @param body
     * @param requestClass
     * @return
     * @throws ParameterNotFoundException
     * @throws MethodArgumentNotValidException
     * @throws UnrecognizedPropertyException
     */
    protected <T> T checkBody(String body, Class<T> requestClass) throws ParameterNotFoundException,
            MethodArgumentNotValidException, UnrecognizedPropertyException {
        ObjectMapper mapper = new ObjectMapper();
        T requestBody = null;
        try {
            if (body == null) {
                throw new ParameterNotFoundException("Missing request body");
            } else {
                requestBody = mapper.readValue(body, requestClass);
//                getValidationEngine().validate(requestBody);
            }
        } catch (IOException e) {
            throw new ParameterNotFoundException("Missing request body", e);
        }
        return requestBody;
    }
}
