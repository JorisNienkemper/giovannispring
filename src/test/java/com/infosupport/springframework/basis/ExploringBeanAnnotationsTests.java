package com.infosupport.springframework.basis;

import com.infosupport.springframework.basis.app.configuration.SpringBeanDefinitions;
import com.infosupport.springframework.basis.app.services.HitBean;
import com.infosupport.springframework.basis.app.services.HitOnceService;
import com.infosupport.springframework.basis.app.services.HitService;
import com.infosupport.springframework.basis.app.services.HitTwiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ExploringBeanAnnotationsTests {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(SpringBeanDefinitions.class);
    }

    @Test
    void testSingletonScope() {
        HitService hitService = context.getBean(HitOnceService.class);
        HitService hitService2 = context.getBean(HitOnceService.class);

        hitService.hit();
        hitService.hit();
        hitService.hit();
        hitService2.hit();

        assertThat(4).isEqualTo(hitService.getHitCount());
        assertThat(4).isEqualTo(hitService2.getHitCount());
    }

    @Test
    void testPrototypeScope() {
        HitService hitService = context.getBean(HitTwiceService.class);
        HitService hitService2 = context.getBean(HitTwiceService.class);

        hitService.hit();
        hitService.hit();
        hitService.hit();

        hitService2.hit();
        hitService2.hit();

        assertThat(6).isEqualTo(hitService.getHitCount());
        assertThat(4).isEqualTo(hitService2.getHitCount());
    }

    @Test
    void testNestedScopes() {
        HitBean hitBean1 = context.getBean(HitBean.class);
        HitBean hitBean2 = context.getBean(HitBean.class);

        hitBean1.hitOnce(); // singleton count = 1
        hitBean2.hitOnce(); // singleton count = 2
        hitBean2.hitOnce(); // singleton count = 3

        hitBean1.hitTwice(); // prototype count = 2
        hitBean1.hitTwice(); // prototype count = 4
        hitBean2.hitTwice(); // prototype2 count = 2

        assertThat(3).isEqualTo(hitBean1.getOnce().getHitCount());
        assertThat(3).isEqualTo(hitBean2.getOnce().getHitCount());

        assertThat(4).isEqualTo(hitBean1.getTwice().getHitCount());
        assertThat(2).isEqualTo(hitBean2.getTwice().getHitCount());
    }
}
