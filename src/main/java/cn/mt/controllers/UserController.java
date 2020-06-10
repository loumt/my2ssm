package cn.mt.controllers;

import cn.mt.exception.ServiceException;
import cn.mt.models.User;
import cn.mt.services.UserService;
import cn.mt.utils.Page;
import cn.mt.utils.ResultEnum;
import cn.mt.utils.StringUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname UserController
 * @Created by loumts
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 19:15
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    public JSONObject login(@RequestBody String username, @RequestBody String md5Password) {
        return null;
    }

    /**
     * 登出
     *
     * @return
     */
    public JSONObject logout() {
        return null;
    }

    /**
     * 查询用户列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    public JSONObject list(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<User> userPage = userService.list(pageNo, pageSize);
        return super.success(userPage);
    }


    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONObject register(@RequestBody User user) {
        if (StringUtil.isEmpty(user.getUsername())) {
            return super.failure(ResultEnum.USERNAME_EMPTY);
        }
        try {
            Long count = userService.count(user.getUsername());
            if(count > 0) {
                return super.failure(ResultEnum.EXIST);
            }
            //正常注册
            Long id = userService.createAccount(user);
            return super.success(id);
        } catch (ServiceException e) {
            return super.failure(ResultEnum.SYSTEM_ERROR);
        }
    }


}
