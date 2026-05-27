package com.rapido.apigateway.filter;

import java.util.UUID;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        String correlationId =
                exchange.getRequest()
                        .getHeaders()
                        .getFirst("X-Correlation-ID");

        if (correlationId == null || correlationId.isBlank()) {
            correlationId = UUID.randomUUID().toString();
        }

        System.out.println(
                "Correlation ID -> " + correlationId
        );

        System.out.println(
                "Incoming Request -> " +
                exchange.getRequest().getMethod() +
                " : " +
                exchange.getRequest().getURI()
        );

        ServerWebExchange updatedExchange =
                exchange.mutate()
                        .request(
                                exchange.getRequest()
                                        .mutate()
                                        .header("X-Correlation-ID", correlationId)
                                        .build()
                        )
                        .build();

        return chain.filter(updatedExchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}