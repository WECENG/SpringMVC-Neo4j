package cn.gdou.services;

import cn.gdou.DAO.domain.LineItem;
import cn.gdou.DAO.domain.Order;
import cn.gdou.DAO.domain.Product;
import cn.gdou.DAO.repository.OrderRepository;
import cn.gdou.DAO.repository.ProductRepository;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    GraphDatabaseService graph;

    public Order saveOrder(){
        Product product=new Product(Long.valueOf(1),"apple",120.0);
        Order order=new Order(Long.valueOf(1),"Wisem","guest");
        LineItem item=new LineItem(Long.valueOf(1),order,product,10);
//        product.setItem(item);
        LinkedHashSet<LineItem> items=new LinkedHashSet<LineItem>();
        items.add(item);
        orderRepository.save(order);
        productRepository.save(product);
        graph.shutdown();
        return order;
    }
}
