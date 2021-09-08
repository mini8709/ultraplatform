package com.tmax.ultraplatform.service;

import com.tmax.ultraplatform.domain.Address;
import com.tmax.ultraplatform.domain.Category;
import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.domain.MemberType;
import com.tmax.ultraplatform.domain.product.Book;
import com.tmax.ultraplatform.domain.product.Product;
import com.tmax.ultraplatform.exception.NotEnoughStockException;
import com.tmax.ultraplatform.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.map;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductServiceTest {

    @Test
    public void 재고더하기() throws Exception{
        //given
        Member seller = createMember();
        Book book = createBook(seller,0);

        //when
        book.addStock(100);
        //then
        assertThat(book.getStockQuantity()).isEqualTo(100);
    }

    @Test
    public void 재고빼기() throws Exception{
        //given
        Member seller = createMember();
        Book book = createBook(seller,10);

        //when
        book.minusStock(5);
        //then
        assertThat(book.getStockQuantity()).isEqualTo(5);
        assertThrows(NotEnoughStockException.class, () -> book.minusStock(10));

    }

    private Book createBook(Member seller,int stock) {
        Category category = new Category("CategoryA");
        List<Category> categories = new ArrayList<>(Arrays.asList(category));
        return Book.createBook(seller, "BookA", stock, 10000, "info", "url", categories, "Author", "sort", "isbn");
    }

    private Member createMember(){
        Address address = new Address();
        address.setCity("서울");
        address.setStreet("마포구");
        address.setZipcode("123-12");
        Member seller = new Member();
        seller.setMembers("1234","123","sellerA",address, MemberType.SELLER,10000);
        return seller;
    }
}
