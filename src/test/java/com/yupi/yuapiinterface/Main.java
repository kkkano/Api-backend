
package com.yupi.yuapiinterface;

import com.yupi.yuapiinterface.client.YuApiClient;
import com.yupi.yuapiinterface.model.User;

public class Main {
    public static void main(String[] args) {
        YuApiClient yuApiClient = new YuApiClient();
        String result1 = yuApiClient.getNameByGet("鱼皮");
        String result2 = yuApiClient.getNameByPost("鱼皮");
        User user = new User();
        user.setUsername("鲤鱼旗");
        String result3 = yuApiClient.getUserNameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}