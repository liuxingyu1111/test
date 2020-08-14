package com.hy.ssm.web;

/*@Controller*/
public class RoleController {
    /*@Autowired
    private IRoleService iRoleService;
*/
/*    @RequestMapping("/queryAll.do")
    public String queryAll(Model model){
        model.addAttribute("list",iRoleService.list(null));
        return "/moban";
    }
    @PostMapping(value = "/delect.do")
    public String del(String id, Role role, Model model){
        System.out.println("----id="+id);
        iRoleService.removeById(id);
        return "redirect:/queryAll.do";
    }*/
/*    @PostMapping(value = "/addstu.do")
    public String hs(Role role, Model model, @RequestParam("filename") MultipartFile pictureFile, HttpServletRequest request)   {
        try {
            System.out.println(pictureFile);
            //就图片名字
            String oriName = pictureFile.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //新图片名字
            String picName = UUID.randomUUID().toString()+extName;
*//*
                   file.transferTo(new File("D://img/" + picName + extName));
*//*
            File file=new File(new File(request.getServletContext().getRealPath("/")).getParent()+"\\"+"image");
            System.out.println("===="+file.getAbsolutePath());
            if(!file.exists()){
                file.mkdir();
            }
            File file1=new File(file+"\\"+picName);
            pictureFile.transferTo(file1);
            role.setFile(picName);
            iRoleService.save(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:queryAll.do";
    }*/
  /*  @GetMapping(value = "/update/{id}.do")
    public String ups(Model model,@PathVariable("id") String id){
        System.out.println(id);
        model.addAttribute("li",iRoleService.update(id));
        return "forward:/update";
    }*/
   /* @GetMapping(value = "/update.do")
    public String up(Model model,int id){
        Role role=iRoleService.update(id);
        model.addAttribute("li",role);
        return "forward:/update1.jsp";
    }*/
}
