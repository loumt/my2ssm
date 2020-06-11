package cn.mt.vo;

import cn.mt.models.User;
import lombok.ToString;

import java.util.List;

/**
 * @Classname UserQueryVo
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/9 13:38
 */
@ToString
public class UserQueryVo {
    private User user;

    private List<Long> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
