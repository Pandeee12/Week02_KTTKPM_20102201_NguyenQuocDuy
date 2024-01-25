package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.OrderRepository;
import vn.edu.iuh.fit.repositories.ProductRepository;
import vn.edu.iuh.fit.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
@RestController

@RequestMapping("/controller")
public class Controller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/products")
    public List<Product> getProducts(){

        return productRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    Order getProductById(@PathVariable long id){
        Product product = restTemplate.getForObject("http://localhost:8081/controller/products/"+id,Product.class);
        Order order = orderRepository.findById(id).get();
        order.setProduct(product);
        return order;
   }

}
