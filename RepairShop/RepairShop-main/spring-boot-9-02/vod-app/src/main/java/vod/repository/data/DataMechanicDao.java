package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Mechanic;
import vod.repository.MechanicDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataMechanicDao implements MechanicDao {

    private final MechanicRepository repository;

    @Override
    public List<Mechanic> findAll() {
        return repository.findAll();
    }

    @Override
    public Mechanic findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Mechanic add(Mechanic m) {return repository.save(m);}
}