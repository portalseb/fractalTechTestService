package com.sebastianportal.fractaltechtest;

import com.sebastianportal.fractaltechtest.models.Order;
import com.sebastianportal.fractaltechtest.models.Product;
import com.sebastianportal.fractaltechtest.models.ProductLine;
import com.sebastianportal.fractaltechtest.repos.OrderRepository;
import com.sebastianportal.fractaltechtest.repos.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FractalTechTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FractalTechTestApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(ProductRepository productRepository, OrderRepository orderRepository){
        return args ->{
            Product ram = new Product();
            String name = "MEMORIA 8GB DDR4 HYPERX PREDATOR BLACK RGB BUS 3000MHZ";
            ram.setName(name);
            ram.setUnitPrice(189.95);
            productRepository.findByName(name)
                    .ifPresentOrElse(p ->{System.out.println("Already created");}, ()->{System.out.println("Inserting product "+ ram);
                        productRepository.insert(ram);});
            Product keyboard = new Product();
            String kbName = "TECLADO RAZER BLACKWIDOW V3 TENKEYLESS MECHANICAL - GREEN SWITCH-CHROMA RGB-BLACK ";
            keyboard.setName(kbName);
            keyboard.setUnitPrice(434.76);
            productRepository.findByName(kbName)
                    .ifPresentOrElse(p ->{System.out.println("Already created");}, ()->{System.out.println("Inserting product "+ keyboard);
                        productRepository.insert(keyboard);});
            Product mice = new Product();
            String miceName = "MOUSE LOGITECH G G603 LIGHTSPEED GAMING WIRELESS BLACK";
            mice.setName(miceName);
            mice.setUnitPrice(189.95);
            productRepository.findByName(miceName)
                    .ifPresentOrElse(p ->{System.out.println("Already created");}, ()->{System.out.println("Inserting product "+ mice);
                        productRepository.insert(mice);});
            ProductLine pl1= new ProductLine();
            pl1.setProduct(ram);
            pl1.setQty(1L);
            pl1.setTotalPrice(ram.getUnitPrice()* pl1.getQty());
            ProductLine pl2= new ProductLine();
            pl2.setProduct(mice);
            pl2.setQty(3L);
            pl2.setTotalPrice(mice.getUnitPrice()* pl2.getQty());
            ProductLine pl3= new ProductLine();
            pl3.setProduct(keyboard);
            pl3.setQty(1L);
            pl3.setTotalPrice(keyboard.getUnitPrice()* pl3.getQty());
            Order order = new Order();
            order.setOrderNo(1L);
            order.setDate(LocalDateTime.now());
            double price = 0;
            List<ProductLine> productList = new ArrayList<>();

            productList.add(pl1);
            productList.add(pl2);
            productList.add(pl3);
            for (ProductLine prodLin: productList) {
                price+=prodLin.getTotalPrice();
            }
            order.setProducts(productList);
            order.setFinalPrice(price);
            orderRepository.findByOrderNo(order.getOrderNo())
                    .ifPresentOrElse(o ->{System.out.println("Already created");}, ()->{System.out.println("Inserting order "+ order);
                orderRepository.insert(order);});
        };
    }

}
