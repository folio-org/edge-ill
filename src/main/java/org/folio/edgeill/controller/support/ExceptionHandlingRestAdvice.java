package org.folio.edgeill.controller.support;

import static org.folio.edgeill.utils.ErrorHelper.ErrorCode.INTERNAL_SERVER_ERROR;
import static org.folio.edgeill.utils.ErrorHelper.ErrorCode.VALIDATION_ERROR;
import static org.folio.edgeill.utils.ErrorHelper.createExternalError;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.folio.edgeill.domain.dto.Error;
import org.folio.edgeill.domain.dto.Errors;
import org.folio.edgeill.domain.dto.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import tools.jackson.databind.json.JsonMapper;

@Log4j2
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlingRestAdvice {

  private final JsonMapper jsonMapper;

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public Errors handleGlobalException(Exception ex) {
    logExceptionMessage(ex);
    return createExternalError(ex.getMessage(), INTERNAL_SERVER_ERROR);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
    MissingServletRequestParameterException.class,
    MethodArgumentTypeMismatchException.class,
    HttpMessageNotReadableException.class,
    IllegalArgumentException.class,
    MethodArgumentNotValidException.class
  })
  public Errors handleValidationErrors(Exception ex) {
    logExceptionMessage(ex);
    return createExternalError(ex.getMessage(), VALIDATION_ERROR);
  }

  /**
   * Exception handler for http client errors, passing them back to the edge API caller. Errors from the exchange client
   * are mapped to {@link Errors} then wrapped into a {@link ResponseEntity} object with the same status code received
   * from the exchange client.
   */
  @ExceptionHandler(HttpStatusCodeException.class)
  public ResponseEntity<Errors> handleExchangeError(HttpStatusCodeException ex) {
    logExceptionMessage(ex);
    var errors = new Errors()
      .addErrorsItem(new Error()
        .type(ex.getClass().getSimpleName())
        .code("INTERACTION_ERROR")
        .message("Failed to retrieve response from mod-ill")
        .addParametersItem(new Parameter()
          .key("responseBody")
          .value(ex.getResponseBodyAsString())))
      .totalRecords(1);
    return new ResponseEntity<>(errors, ex.getStatusCode());
  }

  private static void logExceptionMessage(Exception ex) {
    log.warn("Exception occurred ", ex);
  }
}
