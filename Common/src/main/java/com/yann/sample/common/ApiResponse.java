package com.yann.sample.common;

/**
 * @author shoulai.yang@gmail.com
 * @date 2022/1/5
 */
public class ApiResponse<R> {

  public static final int STATUS_SUCCESS = 0;

  public static final int STATUS_FAILED = 1;

  private int status;

  private R obj;

  private String message;

  public ApiResponse() {
  }

  public ApiResponse(int status) {
    this.status = status;
  }

  public ApiResponse(int status, R obj) {
    this.status = status;
    this.obj = obj;
  }

  public ApiResponse(int status, R obj, String message) {
    this.status = status;
    this.obj = obj;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public R getObj() {
    return obj;
  }

  public void setObj(R obj) {
    this.obj = obj;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isSuccess() {
    return this.status == STATUS_SUCCESS;
  }

  public static <T> ApiResponse<T> success() {
    return new ApiResponse<>(STATUS_SUCCESS);
  }

  public static <T> ApiResponse<T> success(T t) {
    return new ApiResponse<>(STATUS_SUCCESS, t);
  }

  public static <T> ApiResponse<T> success(T t, String message) {
    return new ApiResponse<>(STATUS_SUCCESS, t, message);
  }

  public static <T> ApiResponse<T> error(T t, String message) {
    return new ApiResponse<>(STATUS_FAILED, t, message);
  }

  public static <T> ApiResponse<T> error(String message) {
    return new ApiResponse<>(STATUS_FAILED, null, message);
  }

  public static <T> ApiResponse<T> error() {
    return new ApiResponse<>(STATUS_FAILED);
  }
}
