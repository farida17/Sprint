package com.farida.sprint;

public class WorkList {
    private String name;
    private String recommendation;

    public static WorkList[] workLists = {
            new WorkList("Планирование рабочего дня", "dnfbjkdb"),
            new WorkList("Эффективное сотрудничество", "kjhj"),
            new WorkList("Приобретение новых навыков", "оамоаиоа"),
            new WorkList("Коммуникация с руководителем", "fjgdfhgjkfdj")
    };

    private WorkList(String name, String recommendation) {
        this.name = name;
        this.recommendation = recommendation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
