package com.demoone.data.service;

import com.demoone.data.entity.IdcardInfoExtractor;

/**
 * @author yatao.zhang
 * @version 1.0
 * @since 2019/06/20 11:20
 */
public interface IIdcardInfoExtractorService {

	IdcardInfoExtractor getIdcardInfoExtractor(String code);
}
