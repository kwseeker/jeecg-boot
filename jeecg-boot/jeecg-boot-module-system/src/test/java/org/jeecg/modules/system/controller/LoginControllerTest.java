package org.jeecg.modules.system.controller;

import org.jeecg.JeecgSystemApplication;
import cn.hutool.core.util.RandomUtil;
import org.jeecg.common.util.MD5Util;
import org.jeecg.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * 1 登录流程：
 * 1) 获取验证码（生成随机的4位字符串存redis，key为字符串小写+请求行参数的MD5摘要结果）
 * 2）验证码校验
 * 3）用户有效性校验
 * 4）密码校验
 * 5）获取用户详细信息，生成JWT,有效期1h(jeecg-boot为何用JWT还要往redis中存？)
 * 6）打包用户信息和token返回
 */
//使用@SpringBootTest，Spring将加载所有被管理的bean，基本等同于启动了整个服务，便可以开始功能测试。
//webEnvironment
// MOCK：此值为默认值，该类型提供一个mock环境，可以和@AutoConfigureMockMvc或@AutoConfigureWebTestClient搭配使用，开启Mock相关的功能。注意此时内嵌的服务（servlet容器）并没有真正启动，也不会监听web服务端口。
// RANDOM_PORT：启动一个真实的web服务，监听一个随机端口。
// DEFINED_PORT：启动一个真实的web服务，监听一个定义好的端口（从application.properties读取）。
// NONE：启动一个非web的ApplicationContext，既不提供mock环境，也不提供真实的web服务。
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = JeecgSystemApplication.class)
public class LoginControllerTest extends AbstractTestNGSpringContextTests {
//public class LoginControllerTest {

    private static final String BASE_CHECK_CODES = "qwertyuiplkjhgfdsazxcvbnmQWERTYUPLKJHGFDSAZXCVBNM1234567890";

    @Autowired
    private RedisUtil redisUtil;

    /**
     * http://localhost:8080/jeecg-boot/doc.html#/default/%E7%94%A8%E6%88%B7%E7%99%BB%E5%BD%95/loginUsingPOST
     * 接口入参：
     * {
     * captcha: "KKAn"
     * checkKey: 1636862026443
     * password: "123456"
     * remember_me: true
     * username: "admin"
     * }
     * 功能测试用例：
     * a) 验证码失败，验证码过期
     * b) 用户不存在，注销，已冻结
     * c) 用户密码错误
     * d) 所有信息都正确
     */
    @Test
    public void testLogin() {

    }
}