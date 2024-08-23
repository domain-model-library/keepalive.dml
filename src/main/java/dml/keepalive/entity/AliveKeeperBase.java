package dml.keepalive.entity;

public abstract class AliveKeeperBase implements AliveKeeper {
    private long lastKeepAliveTime;

    @Override
    public void setLastKeepAliveTime(long keepAliveTime) {
        this.lastKeepAliveTime = keepAliveTime;
    }

    @Override
    public boolean isAlive(long currentTime, long keepAliveInterval) {
        return currentTime - lastKeepAliveTime < keepAliveInterval;
    }
}
