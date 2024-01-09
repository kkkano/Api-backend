# 项目背景

API接口调用平台，帮助企业、个人统一开放接口，减少沟通成本，避免重复造轮子，为业务高效赋能。

- 普通用户：注册登录，开通接口调用权限，使用接口。
- 后台：调用统计和可视化分析接口调用情况，管理员发布接口、下线接口、新增接口。

主要功能：

- API接入
- 防止攻击（安全性） 
- 不能随便调用（限制、开通） 
- 统计调用次数 
- 计费 
- 流量保护

架构图：
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1518177/1671091690956-6eb1c6d1-07b3-4c12-9257-28b99e63cc52.png#averageHue=%23fcfcfc&clientId=u77cd8f41-c193-4&from=paste&height=612&id=u411e47da&name=image.png&originHeight=612&originWidth=1096&originalType=binary&ratio=1&rotation=0&showTitle=false&size=64160&status=done&style=none&taskId=uc28e9716-c68a-4e00-9ffb-6fd46bb8324&title=&width=1096)
技术选型：
前端：

- Ant Design Pro
- React
- Ant Design Procomponents
- Umi
- Umi Request(Axios的封装)

后端：

- Spring Boot
- Spring Boot Starter(SDK开发)
- Dubbo (RPC)
- Nacos(注册中心)
- Spring Cloud Gateway(网关、限流、日志实现)

启动方式：
后端：

- api-backend：7529端口，后端接口管理（上传、下线、用户登录）[http://localhost:7529/api/doc.html](http://localhost:7529/api/doc.html)
- api-gateway：8090端口，网关
- api-interface：8123端口，提供各种接口服务（可以有很多个且分布在各个服务器）。这里的tests有个发送请求的跑通流程的测试用例。
- api-client-sdk：客户端SDK，无端口，发送请求到8090端口，由网关进行转发到后端的api-interface

```javascript
@SpringBootTest
class YuapiInterfaceApplicationTests {

    @Resource
    private YuApiClient yuApiClient;

    @Test
    void contextLoads() {
        // 这个方法没有签名认证参数, 会报403
        System.out.println(yuApiClient.getNameByGet("yupi"));

        // 这个方法在请求头添加了签名认证参数, ok
        User user = new User();
        user.setUsername("liyupi");
        String usernameByPost = yuApiClient.getUsernameByPost(user);
        System.out.println(usernameByPost);
    }

}





