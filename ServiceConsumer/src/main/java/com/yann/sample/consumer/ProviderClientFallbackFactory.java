package com.yann.sample.consumer;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author shoulai.yang@gmail.com
 * @date 2022/1/5
 */
@Component
public class ProviderClientFallbackFactory implements FallbackFactory<ProviderClient> {

  @Override
  public ProviderClient create(Throwable cause) {

    return new ProviderClientFallback(cause.getMessage());

  }


}
