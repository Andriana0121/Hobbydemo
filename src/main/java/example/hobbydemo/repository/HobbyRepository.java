package example.hobbydemo.repository;

import example.hobbydemo.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {

}

