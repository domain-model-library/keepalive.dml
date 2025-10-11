package dml.keepalive.entity;

// 注意，具体项目中，应该是有专门的AliveKeeper实现类的，而不是用原有的业务类来充当AliveKeeper。
// 比如，用户会话保活，应该新建一个 UserSessionAliveKeeper ，而不是用 UserSession 来充当 AliveKeeper 。
public interface AliveKeeper {
    void setId(Object id);

    Object getId();

    void setLastKeepAliveTime(long createTime);

    boolean isAlive(long currentTime, long keepAliveInterval);
}
