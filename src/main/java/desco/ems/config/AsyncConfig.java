package desco.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "dbExecutor")
    public Executor dbExecutor() {
        ThreadPoolTaskExecutor ex = new ThreadPoolTaskExecutor();
        ex.setCorePoolSize(60);
        ex.setMaxPoolSize(120);
        ex.setQueueCapacity(1000);
        ex.setThreadNamePrefix("db-");
        ex.initialize();
        return ex;
    }
}