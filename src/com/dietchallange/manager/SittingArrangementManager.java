package com.dietchallange.manager;

import com.dietchallange.exceptions.EqualDietException;
import com.dietchallange.model.Member;

public interface SittingArrangementManager {
    public void add(Member member) throws EqualDietException;
    public void show();
}
