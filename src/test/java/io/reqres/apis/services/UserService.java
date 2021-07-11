package io.reqres.apis.services;


import io.reqres.apis.pojos.UserInformationPojo;
import io.reqres.apis.pojos.UserRegistrationPojo;
import io.reqres.apis.pojos.UserRegistrationResponsePojo;

public interface UserService {

    UserRegistrationResponsePojo createUser(Integer status, UserRegistrationPojo userRegistrationPojo);

    UserInformationPojo getUser(Integer status, Integer id);

    void deleteUser(Integer status, Integer id);
}
