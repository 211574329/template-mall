package com.echo.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echo.mall.config.OssConfig;
import com.echo.mall.constant.TaskConstant;
import com.echo.mall.enums.NumericalEnum;
import com.echo.mall.module.user.dto.UserDTO;
import com.echo.mall.module.user.dto.UserEditDTO;
import com.echo.mall.module.user.dto.UserEditHeadDTO;
import com.echo.mall.module.user.vo.UserVO;
import com.echo.mall.result.entity.R;
import com.echo.mall.server.OssServer;
import com.echo.mall.user.entity.User;
import com.echo.mall.user.mapper.UserMapper;
import com.echo.mall.user.service.IUserService;
import com.echo.mall.util.page.Pages;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author
 * @since 2022-10-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private OssServer ossServer;

    @Override
    public IPage<UserVO> listUser(Pages<UserDTO> pages) {
        IPage<UserVO> iPage = new Page<>(pages.getPageIndex(), pages.getPageSize());
        return userMapper.listUser(iPage, pages.getData());
    }

    @Async(TaskConstant.POOL_NAME)
    @Override
    public void updateUser(UserEditDTO userEditDTO) {
        userMapper.updateUser(userEditDTO);
    }


    @Override
    public String editHead(UserEditHeadDTO userEditHeadDTO) {
        User user = getById(userEditHeadDTO.getId());
        Assert.notNull(user, "用户不存在");

        // 上传新头像
        R<String> r = ossServer.upload(userEditHeadDTO.getFile(), OssConfig.PATH);
        Assert.isTrue(Objects.equals(r.getCode(), NumericalEnum.TWO_HUNDRED.getIntValue()), "头像上传异常");
        String url = r.getData();
        // 更新用户
        LambdaUpdateWrapper<User> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(User::getId, user.getId());
        wrapper.set(User::getHeadPortrait, url);
        update(wrapper);
        // 删除旧头像
        String headPortrait = user.getHeadPortrait();
        if (StringUtils.isNotBlank(headPortrait)){
            ossServer.delete(headPortrait);
        }
        return OssConfig.PREFIX + url;
    }
}
