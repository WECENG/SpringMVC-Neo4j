package cn.gdou.DAO.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.LinkedHashSet;
import java.util.Set;

@NodeEntity
public class Order {
    @Id
    private Long id;        //主键规定必须是Long类型

    private  String customer;

    private String type;

    @Relationship(type = "HAS_ITEMS")
    private Set<LineItem> items=new LinkedHashSet<LineItem>();

    public Order(Long id, String customer, String type) {
        this.id = id;
        this.customer = customer;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<LineItem> getItems() {
        return items;
    }

    public void setItems(Set<LineItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", type='" + type + '\'' +
                ", items=" + items +
                '}';
    }
}


