package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id") //pkl이가 Member_Id ->
    private Long id;

    private String name;

    @Embedded // 내장 타입을 사용할때는 임베디드나 임베디더블 하나만 있어도 되지만 둘 다 추가
    private Address address;

    @OneToMany(mappedBy = "member") // 연관관계의 주인이 아닌, 매핑을 한 거울이라는 것을 나타냄 (읽기 전용)
    private List<Order> orders = new ArrayList<>();
}
