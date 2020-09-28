    package com.rituj.elasticsearch.security.filters;


import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rituj.elasticsearch.conf.RequestTraceId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(value = 1)
public class Filter1 extends OncePerRequestFilter {

 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {

            String traceId = request.getHeader("TraceId");
            traceId = StringUtils.isNotEmpty(traceId) ? traceId : UUID.randomUUID().toString();

            RequestTraceId.setTraceId(traceId);
            MDC.put("TraceId", traceId);

        } catch (Exception ex) {
            log.error("Exception during TraceIdFilter.doFilterInternal()", ex);
        }

        if (StringUtils.isNotBlank(RequestTraceId.getTraceId())) {
            response.setHeader("TraceId", RequestTraceId.getTraceId());
        }

        filterChain.doFilter(request, response);
    }
}
