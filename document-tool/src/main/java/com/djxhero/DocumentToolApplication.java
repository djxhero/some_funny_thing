package com.djxhero;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@SpringBootApplication

@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
@ServletComponentScan
@EnableAutoConfiguration
@MapperScan("com.djxhero.mapper")
public class DocumentToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentToolApplication.class, args);
	}

}
