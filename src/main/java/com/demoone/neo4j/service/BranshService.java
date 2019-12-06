package com.demoone.neo4j.service;

import com.demoone.neo4j.entity.Bransh;
import org.springframework.data.repository.CrudRepository;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/07/11 16:01
 */
public interface BranshService extends CrudRepository<Bransh, Long> {
}
