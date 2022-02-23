package com.yann.sample.consumer;

import com.yann.sample.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author shoulai.yang@gmail.com
 * @date 2021/12/29
 */
@RestController
public class ConsumerController {

  private final RestTemplate restTemplate;

  private final ProviderClient providerClient;

  public ConsumerController(RestTemplate restTemplate, ProviderClient providerClient) {
    this.restTemplate = restTemplate;
    this.providerClient = providerClient;
  }

  @GetMapping(value = "/name")
  public ResponseEntity<ApiResponse<?>> getProviderNameByRestTemplate() {
    ApiResponse<?> response;
    try {
      response = this.restTemplate.getForObject("http://test-service-provider/name", ApiResponse.class);
    } catch (RestClientException e) {
      response = ApiResponse.error(e.getMessage());
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }


  @GetMapping(value = "/name2")
  public ResponseEntity<ApiResponse<String>> getProviderNameByFeignClient() {
    ApiResponse<String> response = this.providerClient.getProviderName();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
