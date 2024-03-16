package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    /*
    하나의 오더가 여러개의 아이템을 가질 수 있고, 오더 아이템은 하나의 오더만 가질 수 있음.
    일대다 관계에서는 다 쪽에 포렌키가 들어간다.
    오더가 연관관계 주인이 되고 매핑
     */

    private int orderPrice; //주문 가격

    private int count; //주문 수량

}
