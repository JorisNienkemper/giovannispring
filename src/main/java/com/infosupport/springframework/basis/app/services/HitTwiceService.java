package com.infosupport.springframework.basis.app.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "hitTwice")
@Scope(scopeName = "prototype")
public class HitTwiceService implements HitService{
    private int hitCount;

    @Override
    public void hit() {
        hitCount += 2;
    }

    @Override
    public int getHitCount() {
        return hitCount;
    }
}
