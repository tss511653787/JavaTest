package boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tss2019
 * @version 1.0
 * @date 2019/5/27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationStartup {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStartup.class, args);
    }
}
