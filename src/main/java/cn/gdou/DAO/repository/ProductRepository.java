package cn.gdou.DAO.repository;

import cn.gdou.DAO.domain.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ProductRepository extends Neo4jRepository<Product,Long> {
    List<Product> findByName();
    List<Product> findById();
}
