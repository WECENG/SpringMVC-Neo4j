package cn.gdou.DAO.repository;

import cn.gdou.DAO.domain.Order;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
public interface OrderRepository extends Neo4jRepository<Order,Long> {

    List<Order> findByCustomer();
    List<Order> findById();
}
