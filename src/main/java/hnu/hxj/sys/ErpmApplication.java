package hnu.hxj.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("hnu.hxj.sys.mapper")
public class ErpmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpmApplication.class, args);
    }

}
