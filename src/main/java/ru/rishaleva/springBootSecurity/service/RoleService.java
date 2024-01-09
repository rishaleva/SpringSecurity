package ru.rishaleva.springBootSecurity.service;

import ru.rishaleva.springBootSecurity.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<Role> getRoles();

    Role findById(Long id);

}
