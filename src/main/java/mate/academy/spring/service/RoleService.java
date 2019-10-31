package mate.academy.spring.service;

import mate.academy.spring.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    void add(Role role);

    Optional<Role> getRoleByName(String name);

    List<Role> getAllRoles();
}
