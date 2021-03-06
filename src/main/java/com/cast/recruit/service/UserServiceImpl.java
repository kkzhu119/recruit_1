package com.cast.recruit.service;

import com.cast.recruit.repository.UserRepository;
import com.cast.recruit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By GuuBohan.
 * On 2018/7/17
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
//        User oldUser = userRepository.findUserByStudentID(user.getStudentID());
        return userRepository.save(user);
    }

//    @Override
//    public List<User> userList() {
//        return userRepository.findAll();
//    }

    @Override        //true则为不空，false则为空
    public Boolean userNotnull(String studentID){
        if (userRepository.findUserByStudentID(studentID)!=null)
            return true;
        return false;
    }

    @Override
    public Boolean equalsToPwd(String studentID, String pwd){
        return userRepository.findUserByStudentID(studentID).getPassword().equals(pwd);
    }

    @Override
    public User findUserByID(String studentID) {
        return userRepository.findUserByStudentID(studentID);
    }
}
