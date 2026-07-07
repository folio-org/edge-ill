package org.folio.edgeill.controller.support;

import static org.apache.logging.log4j.Level.DEBUG;
import static org.apache.logging.log4j.Level.WARN;
import static org.folio.edgeill.utils.ErrorHelper.ErrorCode.INTERNAL_SERVER_ERROR;
import static org.folio.edgeill.utils.ErrorHelper.ErrorCode.VALIDATION_ERROR;
import static org.folio.edgeill.utils.ErrorHelper.createExternalError;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.folio.edgeill.domain.dto.Errors;
import org.folio.spring.exception.FolioContextExecutionException;
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
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import tools.jackson.databind.json.JsonMapper;

@Log4j2
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlingRestAdvice {

  private final JsonMapper jsonMapper;

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public Errors handleGlobalException(Exception ex) {
    logExceptionMessage(WARN, ex);
    return createExternalError(ex.getMessage(), INTERNAL_SERVER_ERROR);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
    MissingServletRequestParameterException.class,
    MissingServletRequestPartException.class,
    MethodArgumentTypeMismatchException.class,
    HttpMessageNotReadableException.class,
    IllegalArgumentException.class,
    MethodArgumentNotValidException.class
  })
  public Errors handleValidationErrors(Exception ex) {
    logExceptionMessage(DEBUG, ex);
    return createExternalError(ex.getMessage(), VALIDATION_ERROR);
  }

  @ExceptionHandler(HttpStatusCodeException.class)
  public ResponseEntity<byte[]> handleExchangeError(HttpStatusCodeException ex) {
    logExceptionMessage(DEBUG, ex);
    return ResponseEntity.status(ex.getStatusCode())
      .headers(ex.getResponseHeaders())
      .body(ex.getResponseBodyAsByteArray());
  }

  @ExceptionHandler(FolioContextExecutionException.class)
  public ResponseEntity<?> handleFolioContextExecutionException(FolioContextExecutionException ex) {
    if (ex.getCause() instanceof HttpStatusCodeException codeException) {
      logExceptionMessage(DEBUG, codeException);
      return ResponseEntity.status(codeException.getStatusCode())
        .headers(codeException.getResponseHeaders())
        .body(codeException.getResponseBodyAsByteArray());
    }

    logExceptionMessage(WARN, ex);
    var error = createExternalError(ex.getMessage(), INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private static void logExceptionMessage(Level logLevel, Exception ex) {
    log.log(logLevel, "Exception occurred ", ex);
  }
}
