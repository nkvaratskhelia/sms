package org.test.sms.server.dao.interfaces.general;

import org.test.sms.common.entity.general.AbstractEntity;
import org.test.sms.common.exception.AppException;
import org.test.sms.common.filter.general.AbstractFilter;

import java.util.List;
import java.util.Optional;

public interface AbstractDao<T extends AbstractEntity> {

    T add(T entity);

    T update(T entity) throws AppException;

    void delete(long id);

    Optional<T> get(AbstractFilter filter);

    long getCount(AbstractFilter filter);

    List<T> getList(AbstractFilter filter);
}