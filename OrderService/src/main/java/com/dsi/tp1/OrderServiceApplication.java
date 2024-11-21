package com.dsi.tp1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dsi.tp1.entity.DeliveryInfo;
import com.dsi.tp1.entity.Ordere;
import com.dsi.tp1.repository.DeliveryinfoRepository;
import com.dsi.tp1.repository.OrdreRepository;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner{
	
	@Autowired
	private OrdreRepository ordreRepository;
	
	@Autowired
	private DeliveryinfoRepository deliveryinfoRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	/*
	@Bean
	public graphql.schema.GraphQLScalarType extendedScalarLong() {
		return graphql.scalars.ExtendedScalars.GraphQLLong;
	}
	*/
	


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ordreRepository.save(new Ordere(Orderenum.created,1,1));
		ordreRepository.save(new Ordere(Orderenum.canceled,2,2));

		deliveryinfoRepository.save(new DeliveryInfo());
		//ordreRepository
	}

}
