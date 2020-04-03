package com.hancakes.Controller;

import com.hancakes.Tool.ValidateImageCodeUtils;
import com.hancakes.entity.Temp;
import com.hancakes.entity.User;
import com.hancakes.service.TempService;
import com.hancakes.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;

@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping("login")
    public String login(String username,String password,HttpSession session){
        User user = userService.login(username, password);
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/Temp/All";
        }else{
            return "redirect:/huamn/login.jsp";
        }
    }

    @PostMapping("regist")
    public String regist(User user,String code,HttpSession session){
        //1、判断验证码是否通过
        if(session.getAttribute("code").toString().equalsIgnoreCase(code)){
            //2、通过就添加注册用户并返回登陆界面
            userService.addUser(user);
            return "redirect:/huamn/login.jsp";
        }else{
            //3、不同过就重定向回注册页面
            return "redirect:/huamn/regist.jsp";
        }
    }


    //生成验证码
    @GetMapping("image")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //将验证码放入session
        session.setAttribute("code",securityCode);
        //生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //输出图片
        ServletOutputStream outputStream = response.getOutputStream();
        //调用工具类
        ImageIO.write(image,"png",outputStream);
    }
}
