package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private  Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY, COMP
    /*enum 타입 사용시 주의점
    @Enumerated 어노테이션 사용해야 하고,
    이 때 지정하는 EnumType이 두가지가 있는데 하나는 ORDINAL, 하나는 String
    ORDINAL은 1,2,3,.. 으로 숫자로 들어가는데중간에 다른게 생기면 망함 > 새로운게 들어가면 숫자가 꼬임
    그래서 반드시 String을 사용
    */
}
