package com.softwarica.emicalculator;

public class Emi {
    private Double emi;
    Emi(Double p,Double r, Double t){
        emi = (p * r * Math.pow(1 + r, t)) / (Math.pow(1 + r, t) - 1);
    }

    Double getEmi(){
        return emi;
    }
}
