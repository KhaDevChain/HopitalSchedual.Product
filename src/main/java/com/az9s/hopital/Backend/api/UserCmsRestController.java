package com.az9s.hopital.Backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.entity.User;
import com.az9s.hopital.Backend.service.UserService;
import com.az9s.hopital.Backend.utils.dto.UserDTO;
import com.az9s.hopital.Backend.utils.http.request.UserRequest;
import com.az9s.hopital.Backend.utils.http.response.BasicResponse;

@RestController
@RequestMapping("/api/user")
public class UserCmsRestController {
    @Autowired
    @Qualifier("logicUserService")
    private UserService userService;

    @PostMapping("/me")
    public ResponseEntity<?> getDetail(@RequestBody UserRequest userRequest) {
        User user = userService.findByEmail(userRequest.getEmail());
        if (user != null) {
            return ResponseEntity.ok(new BasicResponse("Successfully", 200, this.asignUserDTO(user)));
        }
        return ResponseEntity.badRequest().body("User not found");
    }


    /**
     * asign hopital edit
     * @param hopitalRequest
     * @return
     */
    public UserDTO asignUserDTO(User user) {
        UserDTO userDTO = null;
        if (user != null) {
            userDTO = new UserDTO();
            userDTO.setUniqueId(user.getUniqueId());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setFullName(user.getFullName());
            userDTO.setActivated(user.getActivated());
            userDTO.setRoleId(user.getRole().getUniqueId());
            userDTO.setUserRecordDetailId(user.getUserRecord() == null ? null : user.getUserRecord().getUniqueId());
        }
        return userDTO;
    }
}
