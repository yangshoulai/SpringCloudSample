package com.yann.sample.gateway;

import com.yann.sample.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shoulai.yang@gmail.com
 * @date 2022/1/4
 */
@RestController
public class FallbackController {

  @GetMapping("/fallback")
  public ResponseEntity<ApiResponse<?>> fallback() {
    return new ResponseEntity<>(ApiResponse.error("服务不可用"), HttpStatus.OK);
  }
}
