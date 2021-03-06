package com.amm.service.impl;

import com.amm.entity.RefMachTerminalEntity;
import com.amm.exception.ObjectNotFoundException;
import com.amm.repository.RefMachTerminalRepository;
import com.amm.service.RefMachTerminalService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by csw on 2016/8/6 19:50.
 * Explain:
 */
@Component("refMachTerminalService")
@Scope("prototype")
public class RefMachTerminalServiceImpl extends BaseService implements RefMachTerminalService {

    @Autowired
    private RefMachTerminalRepository refMachTerminalRepository;

    public RefMachTerminalEntity findOne(Integer refId) {

        Validate.notNull(refId, "The refMachTerminalId must not be null, find failure.");

        return refMachTerminalRepository.findOne(refId);
    }

    public List<RefMachTerminalEntity> findAll() {
        List<RefMachTerminalEntity> ListRef= (List<RefMachTerminalEntity>) refMachTerminalRepository.findAll();
        return ListRef;
    }

    public RefMachTerminalEntity findById(Integer Id) {
        return refMachTerminalRepository.findById(Id);
    }

    public RefMachTerminalEntity updateRefMachTerminal(RefMachTerminalEntity refMachTerminal) {
        RefMachTerminalEntity saved=this.findById(refMachTerminal.getId());
        if(saved == null) {
            throw new ObjectNotFoundException("用户不存在");
        }
        saved = refMachTerminal.changeUpdateInfoToSave(saved);

        saved = refMachTerminalRepository.save(saved);

        return saved;
    }

    public void delete(Integer id) {
        refMachTerminalRepository.delete(id);
    }
}
