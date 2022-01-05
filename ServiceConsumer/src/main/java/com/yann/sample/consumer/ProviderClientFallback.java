package com.yann.sample.consumer;

import com.yann.sample.common.ApiResponse;

/**
 * @author shoulai.yang@gmail.com
 * @date 2022/1/5
 */
public class ProviderClientFallback implements ProviderClient {

  private final String error;

  public ProviderClientFallback(String error) {
    this.error = error;
  }

  @Override
  public ApiResponse<String> getProviderName() {
    return ApiResponse.error(error);
  }


}
