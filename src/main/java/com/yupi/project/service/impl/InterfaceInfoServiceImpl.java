package com.yupi.project.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.model.entity.InterfaceInfo;
import com.yupi.project.service.InterfaceInfoService;
import com.yupi.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实 现
 * @createDate 12-17 17:07
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
//        Long id = interfaceInfo.getId();
//       String name = interfaceInfo.getName();
//        String description  =interfaceInfo.getDescription();
//        String url =interfaceInfo.getUrl();
//        String requestHeader =interfaceInfo.getRequestHeader();
//        String responseHeader =interfaceInfo.getResponseHeader();
//       Integer status= interfaceInfo.getStatus();
//        String method =interfaceInfo.getMethod();
//        Long userId=interfaceInfo.getUserId();
//        Date creteTime = interfaceInfo.getCreateTime();
//        Date updateTime = interfaceInfo.getUpdateTime();
//        Integer isDelete =interfaceInfo.getIsDelete();
        // 判断接口信息对象是否为空,为空则抛出参数错误的异常
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 获取接口信息对象的名称
        String name = interfaceInfo.getName();

        // 如果是添加操作,所有参数必须非空,否则抛出参数错误的异常
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        // 如果接口名称不为空且长度大于50,抛出参数错误的异常,错误信息为"名称过长"
        // 本期写成<50,(没有解决),第二期视频中解决了
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
}