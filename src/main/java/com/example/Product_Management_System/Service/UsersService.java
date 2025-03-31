package com.example.Product_Management_System.Service;

import com.example.Product_Management_System.DTO.ReqRes;
import com.example.Product_Management_System.Model.Users;
import com.example.Product_Management_System.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ReqRes register(ReqRes registerRequest){

        ReqRes reqResObj = new ReqRes();

        try {

            Users userObj = new Users();

            userObj.setName(registerRequest.getName());
            userObj.setDob(registerRequest.getDob());
            userObj.setGender(registerRequest.getGender());
            userObj.setPreferences(registerRequest.getPreferences());
            userObj.setPhoneNo(registerRequest.getPhoneNo());
            userObj.setAddress(registerRequest.getAddress());
            userObj.setEmail(registerRequest.getEmail());
            userObj.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            userObj.setRole(registerRequest.getRole());

            Users userResult = userRepository.save(userObj);

            if (userResult.getId()>0) {
                reqResObj.setMessage("Registered Successfully");
                reqResObj.setStatusCode(200);
                reqResObj.setUser((userResult));
            }

        }catch (Exception e){
            reqResObj.setError(e.getMessage());
            reqResObj.setStatusCode(500);
        }
        return reqResObj;
    }

    public ReqRes login(ReqRes loginRequest){

        ReqRes reqResObj = new ReqRes();

        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow();
            reqResObj.setMessage("Login Successful");
            reqResObj.setStatusCode(200);
            reqResObj.setRole(user.getRole());
        }catch (Exception e){
            reqResObj.setMessage(e.getMessage());
            reqResObj.setStatusCode(500);
        }
        return reqResObj;
    }

    public ReqRes getAllUsers() {

        ReqRes reqResObj = new ReqRes();

        try {
            List<Users> result = userRepository.findAll();

            if (!result.isEmpty()) {
                reqResObj.setUserList(result);
                reqResObj.setMessage("Get all user success");
                reqResObj.setStatusCode(200);
            } else {
                reqResObj.setMessage("Not found");
                reqResObj.setStatusCode(404);
            }
            return reqResObj;

        } catch (Exception e) {
            reqResObj.setMessage("Error occurred: " + e.getMessage());
            reqResObj.setStatusCode(500);
            return reqResObj;
        }
    }

    public ReqRes deleteUser(Integer userId) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Users> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                userRepository.deleteById(userId);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User deleted successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for deletion");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
        }
        return reqRes;
    }

    public long countUsers() {
        return userRepository.count();
    }
}

