package com.yann.sample.gateway;

import java.util.Objects;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

/**
 * @author shoulai.yang@gmail.com
 * @date 2021/12/29
 */
@SpringBootApplication
public class GatewayApplication {

  @Bean
  public KeyResolver hostKeyResolver() {
    return exchange -> Mono.just(
        Objects.requireNonNull(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName()));
  }

  @Bean
  public RedisRateLimiter redisRateLimiter() {
    return new RedisRateLimiter(1, 1);
  }

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(GatewayApplication.class, args);
  }
}
