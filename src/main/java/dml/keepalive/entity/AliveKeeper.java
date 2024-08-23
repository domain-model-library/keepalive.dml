package dml.keepalive.entity;

public interface AliveKeeper {
    void setId(Object id);

    Object getId();

    void setkeepAliveInterval(long keepAliveInterval);

    void setLastKeepAliveTime(long createTime);

    boolean isAlive(long currentTime);
}
