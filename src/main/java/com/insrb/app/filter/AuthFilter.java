package com.insrb.app.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
@Order(1)
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String service_key = req.getHeader("X-insr-servicekey");
		log.info("Auth Filter: {}: {}, {}", req.getMethod(), req.getRequestURI(), service_key);
		if (service_key == null) {
			res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "invalid access.");
		} else {
            chain.doFilter(request, response);
        }

	}
}