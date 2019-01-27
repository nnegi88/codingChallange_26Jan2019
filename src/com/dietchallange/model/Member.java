package com.dietchallange.model;

public class Member {
    private int biscuitDiet;
    private Member aboveSeatedMember = null;
    private Member lowerSeatedMember = null;

    public Member() {
        this.aboveSeatedMember = null;
        this.lowerSeatedMember = null;
    }

    public Member(int biscuitDiet){
        this.biscuitDiet = biscuitDiet;
        this.aboveSeatedMember = null;
        this.lowerSeatedMember = null;
    }

    public int getBiscuitDiet() {
        return biscuitDiet;
    }

    public void setBiscuitDiet(int biscuitDiet) {
        this.biscuitDiet = biscuitDiet;
    }

    public Member getAboveSeatedMember() {
        return aboveSeatedMember;
    }

    public void setAboveSeatedMember(Member aboveSeatedMember) {
        this.aboveSeatedMember = aboveSeatedMember;
    }

    public Member getLowerSeatedMember() {
        return lowerSeatedMember;
    }

    public void setLowerSeatedMember(Member lowerSeatedMember) {
        this.lowerSeatedMember = lowerSeatedMember;
    }
}
