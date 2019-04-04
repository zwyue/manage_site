package com.zr.gansu.common.auth;

import com.zr.gansu.domain.Course;
import com.zr.gansu.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户详细信息
 * @author: KaiZhang
 * @create: 2019-02-27 14:40
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements UserDetails {

    private Long id;

    private String loginName;

    private String name;

    private String nickName;

    private String password;

    private String salt;

    private Integer identificationNo;

    private Integer credit;

//    private Integer role;

    private Role role;

    private String city;

    private Integer volunteerState;

    private String phone;

    private String icon;

    private String email;

    private Integer sex;

    private Integer age;

    private String sign;

    private String qq;

    private String wechat;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDeleted;

    private Long siteId;

    /**
     * 老师发布的课程，一对多
     */
    private List<Course> courses;

    private Date lastPasswordResetDate;


    /**
     * 返回分配给用户的角色列表
     * @return 角色列表
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRole()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.id.toString();
    }

    /**
     * 账户是否未过期
     * @return true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
