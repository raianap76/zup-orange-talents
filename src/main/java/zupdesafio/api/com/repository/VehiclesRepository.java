package zupdesafio.api.com.repository;

import java.util.List;

import zupdesafio.api.com.model.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByOwner_CPF(int cpf);

}
