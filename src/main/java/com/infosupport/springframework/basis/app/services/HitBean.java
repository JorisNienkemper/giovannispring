package com.infosupport.springframework.basis.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class HitBean {
    @Autowired
    @Qualifier(value = "hitOnce") // singleton scope
    private HitService once;

    @Autowired
    @Qualifier(value = "hitTwice") // prototype scope
    private HitService twice;

    public void hitTwice() {
        twice.hit();
    }

    public void hitOnce() {
        once.hit();
    }

    public HitService getOnce() {
        return once;
    }

    public HitService getTwice() {
        return twice;
    }
}
