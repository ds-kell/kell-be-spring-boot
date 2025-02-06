package vn.com.dsk.demo.base.shared.wrappers;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import vn.com.dsk.demo.base.adapter.dto.response.JwtResponse;
import vn.com.dsk.demo.base.shared.constants.HttpStatusCode;

@UtilityClass
public class ResponseUtils {

    /**
     * Response api
     */
    public ResponseEntity<Response> created(Object data) {
        return new ResponseEntity<>(Response.of(HttpStatusCode.CREATED, "Created", data), HttpStatus.CREATED);
    }

    public ResponseEntity<Response> ok(String msg) {
        return ResponseEntity.ok(Response.of(HttpStatusCode.OK, msg, null));
    }

    public ResponseEntity<Response> ok(Object data) {
        return ResponseEntity.ok(Response.of(HttpStatusCode.CREATED, "Success", data));
    }

    public ResponseEntity<Response> ok(String msg, Object data) {
        return ResponseEntity.ok(Response.of(HttpStatusCode.CREATED, msg, data));
    }

    public ResponseEntity<Response> okCookie(JwtResponse response, Object data) {
        return okCookie(response, "success", data);
    }

    public ResponseEntity<Response> okCookie(JwtResponse response, String msg) {
        return okCookie(response, msg, null);
    }

    public ResponseEntity<Response> okCookie(JwtResponse response, String msg, Object data) {
        ResponseCookie accessCookie = ResponseCookie.from("accessToken", response.getAccessToken())
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(24 * 60 * 60)
                .sameSite("None")
                .build();

        ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", response.getRefreshToken())
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(7 * 24 * 60 * 60)
                .sameSite("None")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, accessCookie.toString())
                .header(HttpHeaders.SET_COOKIE, refreshCookie.toString())
                .body(Response.of(HttpStatusCode.OK, msg, data));
    }

    public ResponseEntity<Response> ok(HttpStatusCode statusCode, String msg, Object data) {
        return ResponseEntity.ok(Response.of(statusCode, msg, data));
    }

    /**
     * Response error
     */
    public ResponseEntity<ErrorResponse> badRequest(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ErrorResponse> unauthorized(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<ErrorResponse> methodNotSupported(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public ResponseEntity<ErrorResponse> mediaTypeNotSupported(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public ResponseEntity<ErrorResponse> internalErr(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}