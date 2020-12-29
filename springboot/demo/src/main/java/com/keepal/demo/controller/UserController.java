package com.keepal.demo.controller;

import com.keepal.demo.domain.User;
import com.keepal.demo.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

    private Log log = LogFactory.getLog(UserController.class);

    /**
     * 用户管理模块的service组件
     */
    @Autowired
    private UserService userService;
//	@Value("${my.conf}")
//	private String myConf;

    /**
     * 查询所有用户
     *
     * @return 用户信息
     * <p>
     * 这个@GetMapping注解表示的就是，这个接口仅仅接收GET类型的http请求
     */
    @GetMapping("/")
    public List<User> listUsers() {
        log.info("查询所有用户");
        return userService.listUsers();
    }

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     * <p>
     * {id}，就是通过占位符的方式，可以让我们提取请求URL中的参数
     * 表明说，我要定位的一个资源是id=3的一个用户
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    /**
     * 新增用户
     *
     * @param user 用户信息
     */
    @PostMapping("/")
    public String saveUser(
            @RequestBody @Validated({User.Save.class}) User user,
            BindingResult bindingResult) {
        // 如果校验失败，则将校验失败信息返回
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            FieldError error = (FieldError) errors.get(0);
            String message = error.getObjectName() + ","
                    + error.getField() + ","
                    + error.getDefaultMessage();
            return "{'status': 'error', 'message': '" + message + "'}";
        }

        userService.saveUser(user);

        return "{'status': 'success', 'message': '新增用户ID为" + user.getId() + "'}";
    }

    /**
     * 更新用户
     *
     * @param user 用户信息
     */
    @PutMapping("/{id}")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "success";
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "success";
    }

}

