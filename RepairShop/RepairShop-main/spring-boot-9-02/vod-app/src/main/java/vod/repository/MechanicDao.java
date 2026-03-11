package vod.repository;

import vod.model.Mechanic;

import java.util.List;

public interface MechanicDao {
    List<Mechanic> findAll();
    Mechanic findById(int id);
    Mechanic add(Mechanic m);
}