package com.mycompany.RemoutedServiceRabbit.services.modelService;

import com.mycompany.RemoutedServiceRabbit.model.ChangeRow;
import com.mycompany.RemoutedServiceRabbit.repositories.ChangeRowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("changeRowService")
public class DefaultChangeRowService implements ChangeRowService{

    @Autowired
    @Qualifier("changeRowRepository")
    private ChangeRowRepository repository;

    @Override
    public List<ChangeRow> getAll() {
        List<ChangeRow> rows = repository.findAll();
        if(rows.size() > 0){
            return rows;
        }else {
            return null;
        }
    }

    @Override
    public ChangeRow add(ChangeRow changeRow) {
        if(changeRow != null){
            return repository.save(changeRow);
        }else {
            return null;
        }
    }

    @Override
    public ChangeRow update(ChangeRow changeRow) {
        if(changeRow.getId() > 0){
            return repository.save(changeRow);
        }else {
            return null;
        }
    }

    @Override
    public void delete(ChangeRow changeRow) {
        repository.delete(changeRow);
    }
}
