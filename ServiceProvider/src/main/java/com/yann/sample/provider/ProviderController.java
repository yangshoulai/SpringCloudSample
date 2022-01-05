package com.yann.sample.provider;

import com.yann.sample.common.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shoulai.yang@gmail.com
 * @date 2021/12/29
 */
@RestController
@RefreshScope
public class ProviderController {

  @Value("${service.provider.name}")
  private String providerName;

  @GetMapping(value = "/name")
  public ResponseEntity<ApiResponse<String>> getProviderName() {
    return new ResponseEntity<>(ApiResponse.success(this.providerName), HttpStatus.OK);
  }

}
