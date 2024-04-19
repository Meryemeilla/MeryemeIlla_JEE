package ma.fsm.jpafsm.service;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.fsm.jpafsm.entities.Role;
import ma.fsm.jpafsm.entities.User;
import ma.fsm.jpafsm.repositories.RoleRepository;
import ma.fsm.jpafsm.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user) ; }
    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }
    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName); }
    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName); }
    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(rolename);
        if (user.getRoles() != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        userRepository.save(user);



    }

    @Override
    public User authenticate(String userName, String password) {
        User user= userRepository.findByUsername(userName);
        if(user == null)   throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Bad credentials");

    }
}