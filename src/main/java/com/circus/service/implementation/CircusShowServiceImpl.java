package com.circus.service.implementation;

import com.circus.domain.Circus;
import com.circus.domain.TypeShow;
import com.circus.repository.api.CircusShowRepositoryApi;
import com.circus.service.api.CircusShowServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CircusShowServiceImpl implements CircusShowServiceApi {

    private final CircusShowRepositoryApi circusShowRepository;

    @Override
    public boolean saveCircusShow(Circus circusSave) {
        Circus circusCheck = circusShowRepository.findAllCircusShow().stream().filter(o1->o1.getName().equals(circusSave.getName())).findFirst().orElse(null);
        if(circusSave!=null && circusCheck==null){
            log.info("Save circus show with sevice,name {} in {}",circusSave.getName(),new Date());
            return circusShowRepository.saveCircusShow(circusSave);
        }else {
            log.error("Cannot save circus show, equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public boolean updateCircusShow(Circus circusUpdate) {
        if(circusUpdate.getId()!=null){
            log.info("Update circus show with sevice,id {} in {}",circusUpdate.getId(),new Date());
            return circusShowRepository.updateCircusShow(circusUpdate);
        }else {
            log.error("Cannot update circus show, equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public Circus getCircusShowById(Long idCircusShow) {
        if(idCircusShow!=null){
            log.info("Update circus show with sevice,id {} in {}",idCircusShow,new Date());
            return circusShowRepository.getCircusShowById(idCircusShow);
        }else {
            log.error("Cannot get circus show by id, equals null in {}",new Date());
            return null;
        }
    }

    @Override
    public List<Circus> findAllCircusShow() {
        log.info("Get all circus show with service, in {}",new Date());
        return circusShowRepository.findAllCircusShow();
    }

    @Override
    public boolean deleteCircusShow(Long idCircusShow) {
        if(idCircusShow!=null){
            log.info("Delete circus show with sevice,id {} in {}",idCircusShow,new Date());
            return circusShowRepository.deleteCircusShow(idCircusShow);
        }else {
            log.error("Cannot delete circus show by id, equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public List<Circus> findAllCircusShowByTypeShow(TypeShow typeShow) {
       if (typeShow!=null){
           log.info("Delete circus show with sevice,id {} in {}",typeShow.getTypeShowname(),new Date());
           return circusShowRepository.findAllCircusShowByTypeShow(typeShow);
       }else{
           log.error("Cannot get circus show by type show, equals null in {}",new Date());
           return null;
       }
    }

    @Override
    public List<Circus> findAllByName(String name) {
       if(!name.equals("")){
           log.info("Get all circus show by name {} in {}",name, new Date());
           return circusShowRepository.findAllByName(name);
       }else{
           log.warn("Get all circus, name equals null in {}",new Date());
           return circusShowRepository.findAllCircusShow();
       }
    }

}
