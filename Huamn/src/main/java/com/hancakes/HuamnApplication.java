package com.hancakes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hancakes.dao")
public class HuamnApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuamnApplication.class, args);
	}

}
