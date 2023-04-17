package com.bwk.desafio;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bwk.entities.Order;
import com.bwk.services.OrderService;

@SpringBootApplication
@ComponentScan({"com.bwk"})
public class DesafioApplication implements CommandLineRunner {
	
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Order order = new Order();
		int code = sc.nextInt();
		order.setCode(code);
		double basic = sc.nextDouble();
		order.setBasic(basic);
		double discount = sc.nextDouble();
		order.setDiscount(discount);
		System.out.printf("Pedido código ", order.getCode());
		System.out.println();
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
		sc.close();
	}
}
