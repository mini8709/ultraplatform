package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrdersRepository {

    private final EntityManager em;

    public void save(Orders orders){

        em.persist(orders);

    }

    public Orders findOrder(Long id){

        return em.find(Orders.class, id);

    }

    public List<Orders> findOrdersByMember(Long id){

        return em.createQuery("select o from orders o where o.member_id = :id", Orders.class)
                .setParameter("id", id).getResultList();

    }

    /*
     * 주문과 주문상품 상세 정보
     */

}
