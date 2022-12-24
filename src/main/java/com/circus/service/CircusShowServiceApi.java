package com.circus.service;

import com.circus.domain.Circus;
import com.circus.domain.TypeShow;

import java.util.List;

public interface CircusShowServiceApi {
    boolean saveCircusShow(Circus circusSave);
    boolean updateCircusShow(Circus circusUpdate);
    Circus getCircusShowById(Long idCircusShow);
    List<Circus> findAllCircusShow();
    boolean deleteCircusShow(Long idCircusShow);
    List<Circus> findAllCircusShowByTypeShow(TypeShow typeShow);

    List<Circus> findAllByName(String name);
}
