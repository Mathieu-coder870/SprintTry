package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.entities.User;
import fr.simplon.domedespuys.repository.UserRepository;
import fr.simplon.domedespuys.service.interfaces.IUserService;

public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public User create(UserPostDTO dto) {
        User user = new User();
        dtoToObject(dto, user);
        return user;
    }

    @Override
    public boolean delete(String id) {

        try {
            userRepository.deleteById(Long.parseLong(id));
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        User user = getById(id);
        if (user != null) {
            dtoToObject(dto, user);
        }

        private void dtoToObject(UserPostDTO dto, User user){
            user.setEmail(dto.email);
            user.setPassword(dto.password);
            user.setFirstname(dto.firstname);
            user.setLastname(dto.lastname);
            userRepository.saveAndFlush(user);
        }
    }

    private void dtoToObject(UserPutDTO dto, User user) {
        user.setFirstname(dto.firstname);
        user.setLastname(dto.lastname);
        user.setPhone(dto.phone);
        userRepository.saveAndFlush(user);
    }
}