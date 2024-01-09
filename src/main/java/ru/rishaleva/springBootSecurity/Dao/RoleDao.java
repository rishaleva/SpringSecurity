package ru.rishaleva.springBootSecurity.Dao;

import org.springframework.stereotype.Repository;
import ru.rishaleva.springBootSecurity.model.Role;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleDao {
    Set<Role> getRoles();

    Role findById(Long id);

}
