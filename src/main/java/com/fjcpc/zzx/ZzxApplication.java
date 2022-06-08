package com.fjcpc.zzx;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ZzxApplication implements ApplicationListener<WebServerInitializedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZzxApplication.class);

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(ZzxApplication.class, args);
    }


    @SneakyThrows
    public void onApplicationEvent(WebServerInitializedEvent event) {
        WebServer server = event.getWebServer();
        WebServerApplicationContext context = event.getApplicationContext();
        Environment env = context.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        int port = server.getPort();
        String contextPath = env.getProperty("server.servlet.context-path");
        if (contextPath == null) {
            contextPath = "";
        }
        List<String> logger = new ArrayList<>();
        LOGGER.info("\n---------------------------------------------------------\n" +
                "\t✅ Application is running! Access address:\n" +
                "\t🏠 Local:\t\thttp://localhost:{}" +
                "\n\t🌐 External:\thttp://{}:{}{}" +
                "\n\t🧩 Swagger:\t\thttp://localhost:{}/swagger-ui/" +
                "\n---------------------------------------------------------\n", port, ip, port, contextPath, port);
    }

}
