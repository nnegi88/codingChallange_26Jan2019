package com.dietchallange.manager.impl;

import com.dietchallange.exceptions.EqualDietException;
import com.dietchallange.exceptions.InvalidMember;
import com.dietchallange.manager.SittingArrangementManager;
import com.dietchallange.model.Member;
import com.dietchallange.utility.SittingArrangementUtility;

public class SittingArrangementManagerImpl implements SittingArrangementManager {
    private Member father;

    private SittingArrangementUtility utility;

    public SittingArrangementManagerImpl(){
        utility = new SittingArrangementUtility();
    }

    @Override
    public void add(Member member) throws EqualDietException {
        if(this.isEmpty()) {
            father = member;
        }
        else {
            this.addToParent(member, this.father);
        }
    }

    private boolean isPresent(Member member) throws InvalidMember {
        if(utility.isSeated(member)) {
            throw new InvalidMember("Not a valid member");
        }
        else {
            return this.isPresent(member, father);
        }
    }

    // PreOrder Traversal is used
    @Override
    public void show() {
        this.show(this.father);
    }

    private void show(Member member) {
        if(!utility.isSeated(member))
            return;
        this.show(member.getLowerSeatedMember());
        this.show(member.getAboveSeatedMember());
        System.out.print(member.getBiscuitDiet()+", ");
    }

    private boolean isPresent(Member member, Member parent) {
        if(member.getBiscuitDiet() == parent.getBiscuitDiet()) {
            return true;
        }
        else if(member.getBiscuitDiet() > parent.getBiscuitDiet()) {
            return this.isPresent(member, parent.getAboveSeatedMember());
        }
        else{
            return this.isPresent(member, parent.getLowerSeatedMember());
        }
    }

    private void addToParent(Member member, Member parent) throws EqualDietException {
        if(member.getBiscuitDiet() > parent.getBiscuitDiet()) {
            if(utility.isSeated(parent.getAboveSeatedMember())) {
                this.addToParent(member, parent.getAboveSeatedMember());
            }
            else {
                parent.setAboveSeatedMember(member);
            }
        }
        else if(member.getBiscuitDiet() < parent.getBiscuitDiet()){
            if(utility.isSeated(parent.getLowerSeatedMember())) {
                this.addToParent(member, parent.getLowerSeatedMember());
            }
            else {
                parent.setLowerSeatedMember(member);
            }
        }
        else {
            throw new EqualDietException("Member with equal biscuit-diet is already present");
        }
    }

    private boolean isEmpty() {
        return father==null;
    }
}
