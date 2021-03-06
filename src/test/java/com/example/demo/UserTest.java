package com.example.demo;

import java.net.URL;
import java.util.List;

import com.example.demo.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


/**
 *
 * @desciption 用户管理测试类
 * @author ChenXiHua
 * @date 2019年2月19日
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

    /**
     * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
     */
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }

    /**
     * 向"/test"地址发送请求，并打印返回结果
     * @throws Exception
     */
//    @Test
//    public void test1() throws Exception {
//
//        ResponseEntity<String> response = this.restTemplate.getForEntity(
//                this.base.toString() + "/demo/hello", String.class, "");
//        System.out.println(String.format("测试结果为：%s", response.getBody()));
//    }

//    @Test
    public void getAllTest() throws Exception {

        ResponseEntity<List> response = this.restTemplate.getForEntity(
                this.base.toString() + "/getAll", List.class, "");
        System.out.println(String.format("测试结果为：%s", response.getBody()));
    }

    @Test
    public void getUserByIdTest() throws Exception {

        ResponseEntity<String> response = this.restTemplate.getForEntity(
                this.base.toString() + "/demo/user/getUser/3", String.class, "");
        System.out.println(String.format("测试结果为：%s", response.getBody()));
    }

}