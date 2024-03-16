package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") //매핑을 뭘로 할거냐 -> 외래키 이름이 member_id
    private  Member member;
    /*
     양방향 연결관계면 연결관계의 주인을 찾아야함
     오더의 회원을 바꿀 때 Member의 값을 바꿀 수도 있고, 멤버를 변경할때 오더를 변경하게 될 수도 있음
     JPA는 그 둘 중 어느걸 확인해야 하는지 지정을 해줘야 한다.

     멤버는 오더스를 리스트로 갖고있고, 오더도 멤버를 가지고 있는데, 문제는 db에서 단 하나있는 orders의 member_id가 있다.
     멤버에도 오더스를 관리하는 오더스라는 필드가 잇고, 오더에도 멤버라는 필드가 있음.
     JPA는 둘 중 어느 쪽의 값이 변경되었을 때 foreign key 값을 바꿔야 하는지(=어느 쪽을 연관관계의 주인으로 둘 지) 알아야 한다.

     이 때 연관관계의 주인은 foreign key가 가까운 곳으로 하면 된다. -> 오데에 있는 멤버가 가까우므로 이를 연관관계의 주인으로 두면 된다.
    */

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delievery_id")
    private Delivery delivery;
    /*
    일대일 관계는 foreign key를 양쪽 어디에다 둬도 되므로 장단점을 비교하여 결정
    강의자는 이를 주로 엑세스를 많이 하는곳에서 둠
    딜리버리를 직접 조회하는 일보다 오더를 보면서 딜리버리를 찾는 경우가 더 많고, 딜리버리로 오더를 찾는 일은 거의없음
    그려면 오더에다가 foreign key를 놓음.
    연관관계주인은 포린키와 가까이에 있는 오더의 딜리버리를 연관관계의 주인으로 둘 수 있다.
     */

    // 이전에 jpa 공부할 때 private Date 타입을 사용할때는 데이트를 쓰면
    // 날짜 관련 어노테이션을 사용해야 했지만 자바8에서는 하이버네이트가 자동으로 지원해줌
    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //[ORDER, CANCEL]
}
