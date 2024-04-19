package ma.fsm.jpafsm.service;

import ma.fsm.jpafsm.entities.Role;
import ma.fsm.jpafsm.entities.User;

public interface UserService  {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String rolename);
    User authenticate(String userName, String password);
}
