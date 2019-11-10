package com.farida.sprint;

public class HealthTask {
    private String name;
    private int image;

    public static HealthTask[] healthLists = new HealthTask[]{
            new HealthTask("Йога", R.drawable.ndbfjhdfbv),
            new HealthTask("Неделя без сахара", R.drawable.ndbfjhdfbv),
            new HealthTask("Неделя без животных продуктов", R.drawable.ndbfjhdfbv),
    };
    private HealthTask(String name, int image) {
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
