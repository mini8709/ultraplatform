package com.tmax.ultraplatform.domain;

/*
 * PAYING : 결제/입금 확인중
 * PREPARING : 상품 준비중 (결제 완료)
 * DELIVERYING : 배송중 (상품 준비 완료)
 * DELIVERED : 배송 완료
 * CANCELLED : 주문 취소됨
 */
public enum OrderStatus {
    PAYING, PREPARING, DELIVERYING, DELIVERED, CANCELLED
}
