package net.Spring.Boot.Repository;

import net.Spring.Boot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
