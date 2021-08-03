package com.example.demo.impl;

import com.example.demo.model.AyUser;
import com.example.demo.model.AyUserRoleRel;
import com.example.demo.service.AyRoleService;
import com.example.demo.service.AyUserRoleRelService;
import com.example.demo.service.AyUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    @Resource
    private AyUserService ayUserService;
    @Resource
    private AyRoleService ayRoleService;
    @Resource
    private AyUserRoleRelService ayUserRoleRelService;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AyUser ayUser = ayUserService.findByUserName(name);
        if(ayUser==null){
            System.out.println("用户不存在");
        }
        List<AyUserRoleRel> ayUserRoleRels = ayUserRoleRelService.findByUserId(ayUser.getId());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (ayUserRoleRels!=null&&ayUserRoleRels.size()>0)
            for (AyUserRoleRel a:
                    ayUserRoleRels) {
                //获取用户关联角色名称
                String rolename = ayRoleService.find(a.getRoleId()).getName();
                authorities.add(new SimpleGrantedAuthority(rolename));

            }

        return new User(ayUser.getName(),ayUser.getPassword(),authorities);
    }
}
