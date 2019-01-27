package com.dietchallange;

import com.dietchallange.exceptions.EqualDietException;
import com.dietchallange.manager.SittingArrangementManager;
import com.dietchallange.manager.impl.SittingArrangementManagerImpl;
import com.dietchallange.model.Member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws EqualDietException {
        SittingArrangementManager arrangement = new SittingArrangementManagerImpl();

        List<Member> members = new ArrayList<Member>(Arrays.asList(
                new Member(4),
                new Member(2),
                new Member(5),
                new Member(1),
                new Member(3)
        ));

        for (Member member : members) { arrangement.add(member); }

        arrangement.show();
    }
}
