package web.service;

import web.models.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    void save(Role role);
    Role getRole(String role);
}

