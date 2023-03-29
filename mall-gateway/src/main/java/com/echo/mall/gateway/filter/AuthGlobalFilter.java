package com.echo.mall.gateway.filter;

import com.echo.mall.gateway.handler.AuthException;
import com.echo.mall.gateway.handler.IllegalityException;
import com.echo.mall.result.enums.ResultEnum;
import com.echo.mall.util.jwt.util.JwtUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * 鉴权过滤器
 */
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter {

    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        // 登录请求放行
        if (request.getURI().getPath().contains("/login")) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst("token");

        if (StringUtils.isBlank(token)) {
            throw new AuthException(ResultEnum.UNAUTHORIZED.getMessage());
        }
        try {
            JwtUtil.parseJWT(token);
        } catch (Exception e) {
            throw new IllegalityException(ResultEnum.ILLEGALITY.getMessage());
        }

        return chain.filter(exchange);
    }
    
}
