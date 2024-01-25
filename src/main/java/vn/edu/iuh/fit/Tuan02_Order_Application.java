package vn.edu.iuh.fit;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.OrderRepository;
import vn.edu.iuh.fit.repositories.ProductRepository;
import vn.edu.iuh.fit.repositories.UserRepository;

import java.util.Locale;
import java.util.Random;

@SpringBootApplication
public class Tuan02_Order_Application {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tuan02_Order_Application.class, args);
	}

	@Bean
	CommandLineRunner test(){
		return args -> {
			Faker faker = new Faker(new Locale("vi","VN"));
			Random random = new Random();

			for (int i = 1; i <= 10; i++) {
				Order order =new Order(faker.name().name(),random.nextInt(1,100));
				orderRepository.save(order);
			}

		};
	}
}
