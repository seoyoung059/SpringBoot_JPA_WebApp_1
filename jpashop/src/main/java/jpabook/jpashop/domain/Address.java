package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Embeddable // 내장 타입을 사용할때는 임베디드나 임베디더블 하나만 있어도 되지만 둘 다 추가
@Getter
public class Address {

    private  String city;
    private String street;
    private String zipcode;
}
