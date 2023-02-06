package com.skii.skiiproject.dao;

import com.skii.skiiproject.model.skier;

import java.util.ArrayList;
import java.util.List;

public class accessskier implements skierdb{

    private static List<skier> db = new ArrayList<>();
    @Override
    public int insertskier(int ID, skier skier) {
        db.add(new skier(skier.getId(), skier.getTime()));
        return 0;
    }
}
