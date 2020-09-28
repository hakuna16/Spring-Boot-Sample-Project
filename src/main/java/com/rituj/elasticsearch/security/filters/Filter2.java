
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

@Slf4j
@Component
@Order(value = 2)
@AllArgsConstructor
public class Filter2 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        String header = request.getHeader("test");
        log.info("in Ist filter");
        
        if(header == null) {
            header ="junk value";
        }
        
        if (header.equals("test")) {

            log.info("dispatching to controller....from the first filter....");
            request.getRequestDispatcher(request.getServletPath()).forward(request, response);
        } else {
            log.info("dispatching to next filter....");
            filterChain.doFilter(request, response);
        }
    }

}
