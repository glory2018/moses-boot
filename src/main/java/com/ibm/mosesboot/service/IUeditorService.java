package com.ibm.mosesboot.service;

import com.ibm.mosesboot.entity.Ueditor;

/**
 * @author Moses
 * @date 2019/7/28
 */
public interface IUeditorService {
    void save(Ueditor ueditor);

    void export(Ueditor ueditor) throws Exception;
}
