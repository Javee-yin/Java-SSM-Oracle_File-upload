package cn.edu.ncu.controller;

import cn.edu.ncu.pojo.Author;
import cn.edu.ncu.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Javee
 * @Date 2020/5/24 18:43
 * @Description
 */
@Controller
@RequestMapping("/user")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @PostMapping("/register.action")
    public ModelAndView register(Author author){
        ModelAndView modelAndView = new ModelAndView();
        authorService.add(author);
        modelAndView.setViewName("redirect:/index.html");
        return modelAndView;
    }

    @PostMapping("/login.action")
    public ModelAndView login(Author author, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:/page/upload.html");

        Author authorSelect = authorService.findByName(author.getName());
        if(author.getName().equals(authorSelect.getName()) &&
        author.getPassword().equals(authorSelect.getPassword())){
            request.getSession().removeAttribute("error");
            request.getSession().setAttribute("user", authorSelect);
            return mv;
        }else{
            mv.setViewName("redirect:/index.html");
            request.getSession().setAttribute("error", "用户名或密码错误！");
            return mv;
        }
    }

    @ResponseBody
    @GetMapping("/errMsg.action")
    public String getMsg(HttpServletRequest request){
        String msg = request.getSession().getAttribute("error").toString();
        return msg;
    }

    @ResponseBody
    @GetMapping("/getUserName.action")
    public String getUserName(HttpServletRequest request){
        Author author = (Author)request.getSession().getAttribute("user");
        return author.getName();
    }
}
