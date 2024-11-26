package com.co.Curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.co.commonservice.models.entity","com.co.usuario.entity"})
@EnableJpaRepositories({"com.co.commonservice.models.entity","com.co.usuario.entity.usuarios.*"})
@EntityScan({"com.co.commonservice.models.entity","com.co.usuario.entity.usuarios.*"})
public class CursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

}
