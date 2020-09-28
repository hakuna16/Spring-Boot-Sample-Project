package com.rituj.elasticsearch.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class applies authentication filter to requests.
 */
@Slf4j
@Component
@AllArgsConstructor
@Order(value = 3)
public class Filter3 extends OncePerRequestFilter {

    

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("in 2nd filter");
        log.info("dispatching to controller....from the 2nd filter....");
        filterChain.doFilter(request, response);
        
    }

}
