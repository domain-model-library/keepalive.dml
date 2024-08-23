import dml.keepalive.entity.AliveKeeperBase;

public class TestAliveKeeper extends AliveKeeperBase {
    private String id;

    @Override
    public void setId(Object id) {
        this.id = (String) id;
    }

    @Override
    public Object getId() {
        return id;
    }
}
