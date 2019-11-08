package com.farida.sprint;

public class HealthList {
    private String name;
    private int image;

    public static HealthList[] healthLists = new HealthList[]{
            new HealthList("Йога", R.drawable.ndbfjhdfbv),
            new HealthList("Неделя без сахара", R.drawable.ndbfjhdfbv),
            new HealthList("Неделя без животных продуктов", R.drawable.ndbfjhdfbv),
    };
    private HealthList(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public int getImage() { return image; }

    public String getName() {
        return name;
    }
    public String toString() {
        return this.name;
    }
}
