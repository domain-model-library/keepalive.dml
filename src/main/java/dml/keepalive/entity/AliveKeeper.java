package dml.keepalive.entity;

public interface AliveKeeper {
    void setId(Object id);

    Object getId();

    void setLastKeepAliveTime(long createTime);

    boolean isAlive(long currentTime, long keepAliveInterval);
}
