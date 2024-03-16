package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    /*
    아이템은 id, name, price, stock quantity, categrories
    상속관계 맵핑을 해야함.

    상속관계 매핑에서는 상속관계 전략을 지정해야 한다
    이는 부모 클래스에서 지정해줘야 하는데 여기서는 싱글테이블 전략 사용
    @Inheritance 어노테이션을 통해 전략을 지정, 싱글테이블, 테이블 퍼 클래스, 조인드가 있다
    조인드는 가장 정규화된 형태, 테이블 퍼 클래스는 북/무비/엘범 3개의 테이블 사용, 싱글테이블은 하나의 테이블에 다 넣어두는것
    @DiscriminatorColumn은 싱글테이블 전략에서 저장할 때 구분하기 위해 사용하는 것을 지정
     */

    private String name;
    private int price;
    private int stockQuantity;

}
