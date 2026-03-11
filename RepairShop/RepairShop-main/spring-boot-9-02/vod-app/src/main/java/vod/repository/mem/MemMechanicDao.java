package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.model.Mechanic;
import vod.repository.MechanicDao;

import java.util.List;

@Repository("MechanicDao")
public class MemMechanicDao implements MechanicDao {
    @Override
    public List<Mechanic> findAll() {
        return SampleData.mechanics;
    }

    @Override
    public Mechanic findById(int id) {
        return SampleData.mechanics.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Mechanic add(Mechanic m) {
        int max = SampleData.mechanics.stream().mapToInt(Mechanic::getId).max().orElse(0);
        m.setId(++max);
        SampleData.mechanics.add(m);
        return m;
    }
}