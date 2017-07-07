package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework
import org.springframework.ui.ModelMap;
import service.UserService;

/**
 * Created by Administrator on 2017/6/22.
 */
@Controller
public class UserLogin {
    @RequestMapping("/userLogin")
    public String check(User user) throws Exception{
        System.out.print(user.getId()+":::::"+user.getPassword());
        UserService userService=new UserService();
        if(userService.check(user.getId(),user.getPassword())!=null){
            return "index.jsp";
        }
        return "Login.jsp";
    }
}
