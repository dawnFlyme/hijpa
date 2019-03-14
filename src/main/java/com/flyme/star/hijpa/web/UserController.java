package com.flyme.star.hijpa.web;

import com.flyme.star.hijpa.base.JSONController;
import com.flyme.star.hijpa.dao.UserDao;
import com.flyme.star.hijpa.entity.User;
import com.flyme.star.hijpa.response.JSONResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * user控制器
 * @RequestMapping 指定访问路径
 * @author Lenovo
 *
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/api/users")
public class UserController extends JSONController {
    @Autowired
    private UserDao userRepository;


    @ApiOperation(value = "获取所有用户")
    @GetMapping
    public JSONResponse list() {
        try {
            List<User> all = (List<User>) userRepository.findAll();
            return success(all);
        }catch (Exception e){
            e.printStackTrace();
            return  fail(e.getMessage());
        }
    }


    @ApiOperation(value = "新增用户")
    @ApiParam(name="user", value="用户",required = true)
    @PostMapping
    public JSONResponse saveUser(@RequestBody  User user) {
        try {
            userRepository.save(user);
            return success("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return  fail(e.getMessage());
        }
    }

    @ApiOperation(value = "修改用户")
    @ApiParam(name="user", value="用户",required = true)
    @PutMapping
    public JSONResponse updateUser(@RequestBody  User user) {
        try {
             userRepository.save(user);
            return success("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return  fail(e.getMessage());
        }
    }


    @ApiOperation(value = "根据用户名查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "path", dataType = "String"),
    })
    @GetMapping (value = "/{userName}")
    public JSONResponse view(@PathVariable("userName") String userName) {
        try {
            User user = userRepository.findUserByName(userName);
            return success(user);
        }catch (Exception e){
            e.printStackTrace();
            return  fail(e.getMessage());
        }
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path")
    })
    @DeleteMapping (value = "/{id}")
    public JSONResponse delete(@PathVariable("id") Long id) {
        try {
            userRepository.deleteById(id);
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return  fail(e.getMessage());
        }
    }


    @ApiOperation(value = "跳转index页面")
    @GetMapping(value = "/toIndex")
    public ModelAndView toDemo(ModelAndView mv) {
        try{
            System.out.println("====>>跳转freemarker页面");
            User user = userRepository.findUserByName("zxf");
            mv.addObject(user);
            mv.setViewName("/views/index");
            return mv;
        }catch (Exception e){
            e.printStackTrace();
        }
        return mv;
    }
}
