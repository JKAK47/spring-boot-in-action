package org.vincent.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vincent.dao.impl.TbUserMapper;
import org.vincent.dao.model.TbUser;
import org.vincent.dao.model.TbUserExample;
import org.vincent.web.out.JsonResult;
import org.vincent.web.vo.User;

import java.util.List;

/**
 * Created by PengRong on 2018/9/18.
 */

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private TbUserMapper userService;

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById (@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try {

            TbUser user = userService.selectByPrimaryKey(id);
            r.getResult().put("user",user);

            r.setMsg("OK");
        } catch (Exception e) {

            r.setMsg("error");
            e.printStackTrace();
        }
        logger.debug(r.toString());
        /** 设置 header */
        ResponseEntity.BodyBuilder builder=ResponseEntity.ok();
        builder.header(HttpHeaders.ACCEPT_ENCODING,"gzip, deflate, br");
        /** 设置body 数据返回*/
        return builder.body(r);
    }

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserList (){
        JsonResult r = new JsonResult();
        try {
            TbUserExample example=new TbUserExample();
            example.createCriteria();
            List<TbUser> users = userService.selectByExample(example);
            r.getResult().put("users",users);

            r.setMsg("ok");
        } catch (Exception e) {

            r.setMsg("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            TbUser tbUser=new TbUser();
            tbUser.setAge(user.getAge());
            tbUser.setCtm(user.getCtm());
            tbUser.setUsername(user.getUsername());
            int orderId = userService.insert(tbUser);
            if (orderId < 0) {
                r.getResult().put("orderId",orderId);

                r.setMsg("fail ");
            } else {
                r.getResult().put("orderId",orderId);

                r.setMsg("ok");
            }
        } catch (Exception e) {
            r.setMsg("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.deleteByPrimaryKey(id);
            if (ret < 0) {
                r.getResult().put("ret",ret);

                r.setMsg(" fail");
            } else {
                r.getResult().put("ret",ret);

                r.setMsg("ok");
            }
        } catch (Exception e) {

            r.setMsg("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("id") Integer id, @RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            TbUser tbUser=new TbUser();
            tbUser.setId(id);
            tbUser.setUsername(user.getUsername());
            tbUser.setCtm(user.getCtm());
            tbUser.setAge(user.getAge());

            int ret = userService.updateByPrimaryKey(tbUser);
            if (ret < 0) {
                r.getResult().put("ret",ret);

                r.setMsg("fail");
            } else {
                r.getResult().put("ret",ret);
                r.setMsg("ok");
            }
        } catch (Exception e) {

            r.setMsg("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

}