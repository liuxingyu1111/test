package com.hy.ssm.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.ssm.bean.*;
import com.hy.ssm.service.*;
import com.hy.ssm.utils.MenuUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class LayuiController {

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private ShuxinService shuxinService;

    @Autowired
    private IRolesService iRolesService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IURService iurService;

    @RequestMapping("/laylist.do")
    @ResponseBody
    public Layui queryAll(Layui layui, Model model, int limit, int page) {
        Page page1 = PageHelper.startPage(page, limit);
        List<Role> li = iRoleService.getUserWithAccount();
        layui.setCode(0);
        layui.setMsg(":");
        layui.setCount((int) page1.getTotal());
        layui.setData(li);
        return layui;
    }

    @GetMapping(value = "/add.do")
    @ResponseBody
    public void ss(Role role, @RequestParam("filename") String card) {
        role.setFile(card);
        iRoleService.save(role);
    }

    @PostMapping("/imgag.do")
    @ResponseBody
    public Layuiimg img(@RequestParam("file") MultipartFile pictureFile, HttpServletRequest request, Model model) {
        Layuiimg layuiimg = new Layuiimg();
        try {
            // 图片上传设置图片名称，不能重复，可以使用uuid
            String picName = UUID.randomUUID().toString();
            // 获取文件名
            String oriName = pictureFile.getOriginalFilename();
            // 获取图片后缀
            String extName = oriName.substring(oriName.lastIndexOf("."));

            String webpath = request.getServletContext().getRealPath("/");
            webpath = webpath.substring(0, webpath.lastIndexOf("\\"));
            webpath = webpath.substring(0, webpath.lastIndexOf("\\"));
            File rootFile = new File(webpath);
            File uploadFile = new File(rootFile, "image");
            if (!uploadFile.exists()) {
                uploadFile.mkdir();
            }
            // 开始上传
            pictureFile.transferTo(new File(webpath + File.separator + "image" + File.separator + picName + extName));
            layuiimg.setCode("200");
            layuiimg.setData(File.separator + picName + extName);
            layuiimg.setMsg("成功");
            return layuiimg;
        } catch (IOException e) {
            layuiimg.setCode("405");
            layuiimg.setMsg("失败");
            e.printStackTrace();
        }
        return layuiimg;
    }

    @GetMapping(value = "/delect.do")
    @ResponseBody
    public void del(Integer id, Role role, Model model) {
        System.out.println("----id=" + id);
        iRoleService.removeById(id);
    }

    /*  @GetMapping(value = "/update1.do")
      public String ups(Model model, Integer id){

          model.addAttribute("li",iRoleService.update(id));
          return "update";
      }*/

    @RequestMapping("/queryShuxin")
    @ResponseBody
    public List<MenuUtils> queryShuxin(){
        return shuxinService.aa();
    }

    @RequestMapping(value = "/sub.do")
    public  String sub(User user, Model model){
        System.out.println("他来了");
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        int count=0;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            count++;
            model.addAttribute("msg","请检查您的名字是否符合要求");
        }catch (IncorrectCredentialsException ice){
            count++;
            model.addAttribute("msg","您的密码输入错误");
        }catch (ExcessiveAttemptsException eae){
            count ++;
            model.addAttribute("msg","您的登录已过时请重新登录");
        }
        if(count>0){
            return "/yichang";
        }

        return "redirect:/layview/zhuye.html";
    }

    @RequestMapping("/role.do")
    @ResponseBody
    public Layui roleAll(Layui layui, Model model, int limit, int page) {
        Page page1 = PageHelper.startPage(page, limit);
        List<User> users=iUserService.list(null);
        List<Roles> li = iRolesService.list(null);
        layui.setCode(0);
        layui.setMsg(":");
        layui.setCount((int) page1.getTotal());
        layui.setData(li);
        return layui;
    }
    @RequestMapping("/userr.do")
    @ResponseBody
    public Layui userAll(Layui layui, Model model, int limit, int page) {
        Page page1 = PageHelper.startPage(page, limit);
        List<User> users=iUserService.list(null);
        layui.setCode(0);
        layui.setMsg(":");
        layui.setCount((int) page1.getTotal());
        layui.setData(users);
        return layui;
    }


    @RequestMapping(value = "/weg.do")
    public String addd(User usrs) {
        int inser=iUserService.adduser(usrs);
        if(inser>0){
            System.out.println("注册成功");
            return "redirect:/layview/login.html";
        }
            return null;
    }

   /* @RequestMapping("/ur.do")
    @ResponseBody
    public Layui urAll(Layui layui, Model model, int limit, int page) {
        //Page page1 = PageHelper.startPage(page, limit);
        List<Users> li = iurService.getURAll();
        for(Users li1:li){
            System.out.println(li1.getUsers()+"==="+li1.getRoles());
        }
        System.out.println(li+"=======");
        layui.setCode(0);
        layui.setMsg(":");
        layui.setCount(li.size());
        layui.setData(li);
        return layui;
    }*/

}