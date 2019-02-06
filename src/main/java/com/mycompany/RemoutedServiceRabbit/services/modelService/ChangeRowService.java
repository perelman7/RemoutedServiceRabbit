package com.mycompany.RemoutedServiceRabbit.services.modelService;

import com.mycompany.RemoutedServiceRabbit.model.ChangeRow;

import java.util.List;

public interface ChangeRowService {

    List<ChangeRow> getAll();
    ChangeRow add(ChangeRow changeRow);
    ChangeRow update(ChangeRow changeRow);
    void delete(ChangeRow changeRow);
}
