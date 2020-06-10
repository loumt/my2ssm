package cn.mt.controllers;

import cn.mt.models.Log;
import cn.mt.models.Role;
import cn.mt.models.User;
import cn.mt.services.LogService;
import cn.mt.services.RoleService;
import cn.mt.services.UserService;
import cn.mt.utils.Page;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname LogController
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/1 19:16
 */
@RestController
@RequestMapping(value = "/log")
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public JSONObject list(@RequestParam int pageNo, @RequestParam int pageSize){
        Page<Log> logPage = logService.list(pageNo, pageSize);
        return super.success(logPage);
    }

}
