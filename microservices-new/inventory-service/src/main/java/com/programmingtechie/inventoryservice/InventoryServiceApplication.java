package com.programmingtechie.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.programmingtechie.inventoryservice")
public class InventoryServiceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository invRep) {
		return args -> {
			Inventory inv = new Inventory();
			inv.setSkuCode("iphone_13");
			inv.setQuantity(100);
			
			Inventory inv2 = new Inventory();
			inv2.setSkuCode("iphone_13");
			inv2.setQuantity(100);
			
			invRep.save(inv);
			invRep.save(inv2);
		};
	}

}
