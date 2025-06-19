package com.az9s.hopital.Backend.api;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.entity.User;
import com.az9s.hopital.Backend.service.UserService;
import com.az9s.hopital.Backend.utils.dto.UserDTO;
import com.az9s.hopital.Backend.utils.http.response.BasicResponse;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
public class UserCmsRestController {
    @Autowired
    @Qualifier("logicUserService")
    private UserService userService;

    @PostMapping("/me")
    public ResponseEntity<?> getDetail(HttpServletRequest request) {
        String data = this.getDataFromCookie(request).get();
        User user = userService.findByEmail(data);
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
            userDTO.setRoleDto(user.getRoleDTO());
            userDTO.setUserRecordDetailId(user.getUserRecord() == null ? null : user.getUserRecord());
        }
        return userDTO;
    }

    /**
     * Lấy thông tin data từ Cookie CMS
     * @param request
     * @return
     */
    public Optional<String> getDataFromCookie(HttpServletRequest request) {
        if (request.getCookies() == null) return Optional.empty();

        String cookieName;
        if (request.getRequestURI().contains("/api/")) {
            cookieName = "ACCESS_DATA_CMS";
        } else if (request.getRequestURI().contains("/api2/")) {
            cookieName = "ACCESS_DATA_WEB";
        } else {
            cookieName = "NONE";
        }
        
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookieName.equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst();
    }
}
