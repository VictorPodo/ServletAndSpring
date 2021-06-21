package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CompasModel implements Serializable {

    private int n1;
    private int n2;
    private int e1;
    private int e2;
    private int es1;
    private int es2;
    private int s1;
    private int s2;
    private int sw1;
    private int sw2;
    private int w1;
    private int w2;
    private int wn1;
    private int wn2;

    private static final CompasModel instance = new CompasModel();

    private static final AtomicInteger newId = new AtomicInteger(1);

    private final Map<Integer, Compas> model;

    private final Map<String, String> map = new HashMap<String, String>();

    public CompasModel() {
        model = new HashMap<Integer, Compas>();
    }

    public static CompasModel getInstance(){
        return instance;
    }


    public Map<String,String> setDegree (int Degree) {
        if (Degree > n1 || Degree < n2) {
            map.put("Side","North");
        } else
        if (Degree > e1 || Degree < e2) {
            map.put("Side", "East");
        } else
        if (Degree > es1 || Degree < es2) {
            map.put("Side", "East-South");
        } else
        if (Degree > s1 || Degree < s2) {
            map.put("Side", "South");
        } else
        if (Degree > sw1 || Degree < sw2) {
            map.put("Side", "South-West");
        } else
        if (Degree > w1 || Degree < w2) {
            map.put("Side", "West");
        } else
        if (Degree > wn1 || Degree < wn2) {
            map.put("Side", "West-North");
        }
        return map;
    }

    public void setSides (
            int n1,
            int n2,
            int e1,
            int e2,
            int es1,
            int es2,
            int s1,
            int s2,
            int sw1,
            int sw2,
            int w1,
            int w2,
            int wn1,
            int wn2
    )
    {
        this.n1 = n1;
        this.n2 = n2;
                this.e1 = e1;
                this.e2 = e2;
                this.es1 = es1;
                this.es1 = es2;
                this.s1 = s1;
                this.s1 = s2;
                this.sw1 = sw1;
                this.sw1 = sw2;
                this.w1 = w1;
                this.w1 = w2;
                this.wn1 = wn1;
                this.wn1 = wn2;

    }

    public Map<Integer, Compas> getAll(){
        return model;
    }

}
