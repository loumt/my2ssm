package cn.mt.controllers;

import cn.mt.dao.LogDao;
import cn.mt.models.Log;
import cn.mt.models.Role;
import cn.mt.models.User;
import cn.mt.services.LogService;
import cn.mt.services.RoleService;
import cn.mt.services.UserService;
import cn.mt.utils.Page;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/home")
public class PageController extends BaseController {

    @RequestMapping
    public String home() {
        return "home";
    }

}
