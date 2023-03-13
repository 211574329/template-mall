package com.sike.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sike.mall.enums.NumericalEnum;
import com.sike.mall.module.user.dto.UserDTO;
import com.sike.mall.module.user.dto.UserEditDTO;
import com.sike.mall.module.user.vo.UserVO;
import com.sike.mall.plugins.oss.constant.OssConstant;
import com.sike.mall.plugins.oss.result.OssResult;
import com.sike.mall.plugins.oss.util.OssUtil;
import com.sike.mall.user.entity.User;
import com.sike.mall.user.mapper.UserMapper;
import com.sike.mall.user.service.IUserService;
import com.sike.mall.util.page.Pages;
import org.apache.commons.lang3.StringUtils;
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
    private OssUtil ossUtil;

    @Override
    public IPage<UserVO> listUser(Pages<UserDTO> pages) {
        IPage<UserVO> iPage = new Page<>(pages.getPageIndex(), pages.getPageSize());
        return userMapper.listUser(iPage, pages.getData());
    }

    @Override
    public String editHead(UserEditDTO userEditDTO) {
        User user = getById(userEditDTO.getId());
        Assert.notNull(user, "用户不存在");

        OssResult<String> result = ossUtil.upload(userEditDTO.getFile(), OssConstant.HEAD_PORTRAIT_PATH);
        Assert.isTrue(Objects.equals(result.getCode(), NumericalEnum.TWO_HUNDRED.getNumerical()), "头像上传异常");

        String headPortrait = user.getHeadPortrait();
        if (StringUtils.isNotBlank(headPortrait)){
            ossUtil.delete(headPortrait);
        }
        String url = result.getData();
        LambdaUpdateWrapper<User> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(User::getId, user.getId());
        wrapper.set(User::getHeadPortrait, url);
        update(wrapper);
        return OssConstant.URL_PREFIX + url;
    }
}
