package com.hancakes.Controller;

import com.hancakes.entity.Temp;
import com.hancakes.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("Temp")
public class TempController {

    @Autowired
    private TempService tempService;

    //删除
    @GetMapping("delete")
    public String delete(String id){
        tempService.delete(id);
        return "redirect:/Temp/All";
    }

    //执行修改
    @PostMapping("getUpdate")
    public String getUpdate(Temp temp){
        tempService.getUpdate(temp);
        return "redirect:/Temp/All";
    }

    //传入修改页面信息
    @GetMapping("message")
    public String message(String id,Model model){
        Temp temp = tempService.updatebyid(id);
        model.addAttribute("temp",temp);
        return "/huamn/updateEmp";
    }

    //添加表人物信息
    @PostMapping("insert")
    public String insert(Temp temp){
            tempService.insertTemp(temp);
            return "redirect:/Temp/All";
    }

    //获取表格信息
    @GetMapping("All")
    public String All(Model model){
        List<Temp> temps = tempService.selectTemp();
        model.addAttribute("temp",temps);
        return "huamn/emplist";
    }
}
