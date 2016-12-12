package guru.uit.authnproxy;

import org.eclipse.jetty.proxy.AsyncProxyServlet;
import org.eclipse.jetty.proxy.ProxyServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arien on 10-Dec-16.
 */
@SpringBootApplication
public class Application {

    @Bean
    public ServletRegistrationBean proxyServlet(final ServletConfig dispatcherServlet, @Value("${destination.url}") String destUrl) throws ServletException {
        ProxyServlet.Transparent proxyServlet = new ProxyServlet.Transparent();
        final Map<String, String> params = new HashMap<String, String>();
        params.put("proxyTo", destUrl);
        params.put("prefix", "/proxy");
        params.put("idleTimeout", "5000");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(proxyServlet, "/proxy/*");
        servletRegistrationBean.setAsyncSupported(true);
        servletRegistrationBean.setName("proxyServlet");
        servletRegistrationBean.setInitParameters(params);
        return servletRegistrationBean;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
