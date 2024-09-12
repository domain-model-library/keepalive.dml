package dml.keepalive.service;

import dml.keepalive.entity.AliveKeeper;
import dml.keepalive.repository.AliveKeeperRepository;
import dml.keepalive.service.repositoryset.AliveKeeperServiceRepositorySet;

public class KeepAliveService {
    public static AliveKeeper createAliveKeeper(AliveKeeperServiceRepositorySet repositorySet,
                                                Object Id, long createTime, AliveKeeper newAliveKeeper) {
        AliveKeeperRepository<AliveKeeper, Object> aliveKeeperRepository = repositorySet.getAliveKeeperRepository();

        newAliveKeeper.setId(Id);
        newAliveKeeper.setLastKeepAliveTime(createTime);
        aliveKeeperRepository.put(newAliveKeeper);
        return newAliveKeeper;
    }

    public static boolean isAlive(AliveKeeperServiceRepositorySet repositorySet,
                                  Object id, long currentTime, long keepAliveInterval) {
        AliveKeeperRepository<AliveKeeper, Object> aliveKeeperRepository = repositorySet.getAliveKeeperRepository();

        AliveKeeper aliveKeeper = aliveKeeperRepository.find(id);
        if (aliveKeeper == null) {
            return false;
        }
        boolean alive = aliveKeeper.isAlive(currentTime, keepAliveInterval);
        return alive;
    }

    public static void keepAlive(AliveKeeperServiceRepositorySet aliveKeeperServiceRepositorySet,
                                 Object id, long currentTime) {
        AliveKeeperRepository<AliveKeeper, Object> aliveKeeperRepository = aliveKeeperServiceRepositorySet.getAliveKeeperRepository();

        AliveKeeper aliveKeeper = aliveKeeperRepository.take(id);
        aliveKeeper.setLastKeepAliveTime(currentTime);
    }

    public static AliveKeeper removeAliveKeeper(AliveKeeperServiceRepositorySet aliveKeeperServiceRepositorySet,
                                                Object id) {
        AliveKeeperRepository<AliveKeeper, Object> aliveKeeperRepository = aliveKeeperServiceRepositorySet.getAliveKeeperRepository();

        return aliveKeeperRepository.remove(id);
    }
}
