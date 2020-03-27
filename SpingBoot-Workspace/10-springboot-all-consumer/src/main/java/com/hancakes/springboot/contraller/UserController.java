package com.hancakes.springboot.contraller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hancakes.springboot.model.User;
import com.hancakes.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(value = "curPage",required = false)Integer curPage){

        //1每页有多少行数(固定)
        int pagSize = 5;

        //6curPage当前是在几页
        if(curPage == null){
            curPage = 1;
        }

        //2总行数
        int totaRows = userService.getUserByTotal();
        //3计算总页数
        int totaPages = totaRows / pagSize ;

        //4计算是否有余数(有则多一页)
        int left = totaRows % pagSize ;
        if(left>0){
            totaPages = totaPages + 1;
        }

        //7如果当前页超过或是负数总页数会报错
        //让页面到尾页
        if(curPage > totaPages){
            curPage = totaPages;
        }
        //让页面到首页
        if(curPage < 1){
            curPage = 1;
        }

        //5startRow：开始行     curPage：当前是在几页
        int startRow = (curPage - 1 ) * pagSize;

        Map<String,Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow",startRow);
        paramMap.put("pageSize",pagSize);
        List<User> userList = userService.getUserByPage(paramMap);

        model.addAttribute("userList",userList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totaPages",totaPages);

        return "index";
    }

    //指定添加页面
    @RequestMapping("/User/addShow")
    public String addShow(){
        return "addUser";
    }

    //添加 //修改
    @RequestMapping("/user/addUser")
    public String addUser(User user){

        Integer id = user.getId();
        if(id==null){
            //添加用户
            userService.addUser(user);
        }else{
            //返回修改用户
            userService.updateUser(user);
        }

        return "redirect:/index";
    }

    //回显要修改数据
    @RequestMapping("/user/updateShow")
    public String updateShow(Model model,@RequestParam("id") Integer id){

        User user = userService.getUserById(id);
        model.addAttribute("user",user);

        return "addUser";
    }

    @RequestMapping("/user/delete")
    public String delete(Integer id){

        userService.deleteUser(id);

        return "redirect:/index";
    }
}
