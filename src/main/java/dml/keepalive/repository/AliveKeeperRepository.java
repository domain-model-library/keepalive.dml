package dml.keepalive.repository;

import dml.common.repository.CommonRepository;
import dml.keepalive.entity.AliveKeeper;

public interface AliveKeeperRepository<E extends AliveKeeper, ID> extends CommonRepository<E, ID> {
}
