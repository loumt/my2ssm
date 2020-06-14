package cn.mt.controllers;

import cn.mt.domain.Account;
import cn.mt.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname AccountController
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description 账户控制层
 * @Date 2020/6/14 23:16
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String page(){
        return "home";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> index(){
        Map<String,Object> result = new HashMap<>();
        System.out.println("Ok");
        List<Account> allAccount = accountService.getAllAccount();
        result.put("result", allAccount);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Map<String,Object> addAccount(Account account){
        Map<String,Object> result = new HashMap<>();
        System.out.println("Save Account");
        System.out.println(account);
        accountService.saveAccount(account);
        result.put("result", true);
        return result;
    }





}
