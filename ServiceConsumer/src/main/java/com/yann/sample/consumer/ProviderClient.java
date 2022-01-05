package com.yann.sample.consumer;

import com.yann.sample.common.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shoulai.yang@gmail.com
 * @date 2022/1/5
 */
@Component
@FeignClient(value = "service-provider", fallbackFactory = ProviderClientFallbackFactory.class)
public interface ProviderClient {

  @GetMapping(value = "/name")
  public ApiResponse<String> getProviderName();

}
