package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.Order;
import com.ijse.hellospring.entity.Product;
import com.ijse.hellospring.repository.OrderRepository;
import com.ijse.hellospring.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public Order addProductToOrder(Long orderId, Long productId, int quantity){
        Order order = orderRepository.findById(orderId).orElse(null);

        if (order == null) {
            return null;
        }

        Product product = productRepository.findById(productId).orElse(null);

        if(product == null){
            return null;
        }

        order.getOrderedProducts().add(product);
        order.setTotalPrice(order.getTotalPrice() + product.getPrice() * quantity);
        product.setQty(product.getQty() - quantity);

        return orderRepository.save(order);
    }

    // @Override
    // public Order removeProductfromOrder(Long orderId, Long productId){
    //     Order order = orderRepository.findById(orderId).orElse(null);

    //     if(order == null) return null;

    //     Product product = productRepository.findById(productId).orElse(null);

    //     if(product == null) return null;

    //     order.getOrderedProducts().remove(product);
    //     order.setTotalPrice(order.getTotalPrice() - product.getPrice());
    //     // product.setQty(product.getQty() + quantity);

    //     return orderRepository.save(order);
    // }

    public Order removeProductfromOrder(Long orderId, Long productId, int quantity) {
        Order order = orderRepository.findById(orderId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
    
        if (order != null && product != null) {
            // Remove the product from the order
            order.getOrderedProducts().removeIf(op -> op.getId().equals(productId));
            order.setTotalPrice(order.getTotalPrice() + product.getPrice() * quantity);
            
            // Update the product store quantity
            product.setQty(product.getQty() + quantity);
            productRepository.save(product);
    
            return orderRepository.save(order);
        }
        return null;
    }
    
}
