package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    // 엔티티 매니저를
    @PersistenceContext
    private EntityManager em;
    // 스프링부트가 엔티티매니저 생성 알아서 해줌

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
        //커맨드와 쿼리를 분리
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
