package com.unclefallingdownthestairs.gruhdimension;

import java.util.ArrayList;

public class GruhLocation {

    static ArrayList<GruhLocation> locations = new ArrayList<>();

    public Integer id;
    public String displayName;

    public GruhLocation(String name) {
        id = locations.size();
        displayName = name;

        locations.add(this);
    }

}
