package ru.labanalysisksm.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
// TODO Обработка исключений
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private Date timestamp;

    private String message;

    private HttpStatus httpStatus;

    private int code;

    public ErrorResponse(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}
