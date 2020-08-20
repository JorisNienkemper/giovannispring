package com.infosupport.springframework.basis.app.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@HitOnce
public class HitOnceService implements HitService {
    private int hitCount;

    public void hit() {
        ++hitCount;
    }

    public int getHitCount() {
        return hitCount;
    }
}
