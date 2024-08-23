package dml.keepalive.entity;

public abstract class AliveKeeperBase implements AliveKeeper {
    private long keepAliveInterval;
    private long lastKeepAliveTime;

    @Override
    public void setkeepAliveInterval(long keepAliveInterval) {
        this.keepAliveInterval = keepAliveInterval;
    }

    @Override
    public void setLastKeepAliveTime(long keepAliveTime) {
        this.lastKeepAliveTime = keepAliveTime;
    }

    @Override
    public boolean isAlive(long currentTime) {
        return currentTime - lastKeepAliveTime < keepAliveInterval;
    }
}
