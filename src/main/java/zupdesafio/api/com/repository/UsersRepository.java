package zupdesafio.api.com.repository;

import zupdesafio.api.com.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {

    User findByCPF(int cpf);

}
