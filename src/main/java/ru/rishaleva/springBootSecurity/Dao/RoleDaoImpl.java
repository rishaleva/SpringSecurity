package ru.rishaleva.springBootSecurity.Dao;

import org.springframework.stereotype.Repository;
import ru.rishaleva.springBootSecurity.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Set<Role> getRoles() {
        return entityManager.createQuery("from Role", Role.class)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    @Override
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
