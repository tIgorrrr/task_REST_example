package pl.igor.testtask2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import stripe.PaymentService;
import stripe.StripePaymentService;

@SpringBootApplication
public class TestTask2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestTask2Application.class, args);
	}

	@Bean
	public PaymentService paymentService() {
		return new StripePaymentService("fdfdf");
	}

}
