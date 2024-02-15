package br.com.guiautos.repositories;


import br.com.guiautos.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByMarca(String marca);

    List<Carro> findByPrecoBetween(Double param1,Double param2);

}
