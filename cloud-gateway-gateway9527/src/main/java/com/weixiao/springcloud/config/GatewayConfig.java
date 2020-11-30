package com.weixiao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :weixiao
 * @description : 配置一个id为route-name的路由规则
 * 当访问http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
 * @date :2020/11/30 16:38
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_weixiao",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
}
