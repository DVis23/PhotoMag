package ru.vsu.cs.dvis;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public abstract class Tool {
    private String id;
    private String type;
    private static Set<String> allToolsIds = new HashSet<>();

    protected Tool(String id) {
        this.id = id;
        this.type = "";
    }

    protected Tool() {
        do {
            id = UUID.randomUUID().toString();
        } while (!allToolsIds.add(id));
        this.type = "";

    }
    public abstract Map<String, Object> getParameters();

    public static Set<String> getAllToolsIds() {
        return allToolsIds;
    }
    public static void setAllToolsIds(Set<String> allToolsIds) {
        Tool.allToolsIds = allToolsIds;
    }
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
