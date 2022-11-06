package com.mueblesStgo.mueblesStgo.repositories;

import com.mueblesStgo.mueblesStgo.entities.JustificativoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustificativoRepository extends CrudRepository<JustificativoEntity, Long> {

}
