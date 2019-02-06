package com.mycompany.RemoutedServiceRabbit.repositories;

import com.mycompany.RemoutedServiceRabbit.model.ChangeRow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("changeRowRepository")
public interface ChangeRowRepository extends MongoRepository<ChangeRow, Long> { }
