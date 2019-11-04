package net.ys.filter;

import net.ys.util.LogUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class ApiFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        Enumeration<String> names = request.getParameterNames();
        String name;
        String newLine = "\r\n";
        StringBuffer sb = new StringBuffer("request uri-->" + uri + newLine);
        while (names.hasMoreElements()) {
            name = names.nextElement();
            sb.append(name + "->" + request.getParameter(name) + newLine);
        }
        LogUtil.debug(sb);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}