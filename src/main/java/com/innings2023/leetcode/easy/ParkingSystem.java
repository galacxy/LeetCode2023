package com.innings2023.leetcode.easy;

public class ParkingSystem {
    private static enum CAR_TYPE{
        SMALL,
        MEDIUM,
        BIG;
    }

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.small = small;
        this.medium = medium;
        this.big = big;
    }
    
    public boolean addCar(int carType) {
        if(CAR_TYPE.SMALL.ordinal()+1 == carType){
            if(this.small > 0){
                this.small--;
                return true;
            } else {
                return false;
            }
        } else if (CAR_TYPE.MEDIUM.ordinal()+1 == carType){
            if(this.medium > 0){
                this.medium--;
                return true;
            } else {
                return false;
            }
        } else if (CAR_TYPE.BIG.ordinal()+1 == carType) {
            if(this.big > 0){
                this.big--;
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
