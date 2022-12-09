package com.example.service;

import com.example.dao.UserDAO;
import com.example.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }
}
