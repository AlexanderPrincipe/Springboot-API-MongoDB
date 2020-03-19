package com.example.demo.Repository;

import com.example.demo.Document.Empleado;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.List;

@Repository
// @RepositoryRestResource(path = "talentfestapi")
@CrossOrigin(value = {})
public interface EmpleadoRepo extends MongoRepository<Empleado, Serializable> {

    @RestResource(path = "codigo",rel = "codigo")
    public List<Empleado> findByCodigoOrderByNombre(@Param("codigo")String codigo, Pageable pageable);

}
