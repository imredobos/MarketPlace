package com.imredobos.marketplace;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class MarketPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketPlaceApplication.class, args);
	}

}

