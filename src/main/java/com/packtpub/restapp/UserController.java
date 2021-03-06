package com.packtpub.restapp;

import com.packtpub.aop.TokenRequired;
import com.packtpub.model.User;
import com.packtpub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userSevice;

    @ResponseBody
    @RequestMapping("")
    public List<User> getAllUsers() {
        return userSevice.getAllUsers();
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userSevice.getUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> createUser(@RequestParam(value = "userid") Integer userid,
                                          @RequestParam(value = "username") String username) {
        Map<String, Object> map = new LinkedHashMap<>();
        userSevice.createUser(userid, username);
        map.put("result", "added");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String, Object> updateUser(@RequestParam(value = "userid") Integer userid,
                                          @RequestParam(value = "username") String username) {
        Map<String, Object> map = new LinkedHashMap<>();
        userSevice.updateUser(userid, username);
        map.put("result", "updated");
        return map;
    }

    @ResponseBody
    @TokenRequired
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteUser(
            @PathVariable("id") Integer userid) {
        Map<String, Object> map = new LinkedHashMap<>();
        userSevice.deleteUser(userid);
        map.put("result", "deleted");
        return map;
    }
}