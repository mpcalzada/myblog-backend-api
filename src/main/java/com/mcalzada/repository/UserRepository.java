package com.mcalzada.repository;

import com.mcalzada.crud.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link UserRepository}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */

public interface UserRepository extends JpaRepository<User, Long>
{

}
