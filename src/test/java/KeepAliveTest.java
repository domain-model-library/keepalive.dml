import dml.common.repository.TestCommonRepository;
import dml.keepalive.entity.AliveKeeper;
import dml.keepalive.repository.AliveKeeperRepository;
import dml.keepalive.service.KeepAliveService;
import dml.keepalive.service.repositoryset.AliveKeeperServiceRepositorySet;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KeepAliveTest {

    @Test
    public void test() {

        long currentTime = 0L;
        long keepAliveInterval = 1000L;
        //创建一个aliveKeeper
        AliveKeeper aliveKeeper = KeepAliveService.createAliveKeeper(aliveKeeperServiceRepositorySet,
                "1", currentTime, new TestAliveKeeper());

        //时间过了500毫秒，检查是否存活
        currentTime += 500;
        boolean alive = KeepAliveService.isAlive(aliveKeeperServiceRepositorySet,
                aliveKeeper.getId(), currentTime, keepAliveInterval);
        assertTrue(alive);

        //活跃了一次
        KeepAliveService.keepAlive(aliveKeeperServiceRepositorySet,
                aliveKeeper.getId(), currentTime);

        //时间过了500毫秒，检查是否存活
        currentTime += 500;
        alive = KeepAliveService.isAlive(aliveKeeperServiceRepositorySet,
                aliveKeeper.getId(), currentTime, keepAliveInterval);
        assertTrue(alive);

        //时间过了500毫秒，检查是否存活
        currentTime += 500;
        alive = KeepAliveService.isAlive(aliveKeeperServiceRepositorySet,
                aliveKeeper.getId(), currentTime, keepAliveInterval);
        assertFalse(alive);

        //删除aliveKeeper
        aliveKeeper = KeepAliveService.removeAliveKeeper(aliveKeeperServiceRepositorySet,
                aliveKeeper.getId());
    }

    AliveKeeperRepository aliveKeeperRepository = TestCommonRepository.instance(AliveKeeperRepository.class);

    AliveKeeperServiceRepositorySet aliveKeeperServiceRepositorySet = new AliveKeeperServiceRepositorySet() {
        @Override
        public AliveKeeperRepository getAliveKeeperRepository() {
            return aliveKeeperRepository;
        }
    };

}
