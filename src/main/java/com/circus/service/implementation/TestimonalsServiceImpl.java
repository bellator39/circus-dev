package com.circus.service.implementation;

import com.circus.domain.Testimonals;
import com.circus.repository.api.TestimonalsRepositoryApi;
import com.circus.service.api.TestimonalsServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class TestimonalsServiceImpl implements TestimonalsServiceApi {

    private final TestimonalsRepositoryApi testimonalsRepository;

    @Override
    public boolean saveTestimonals(Testimonals testimonals) {
        if(testimonals!=null){
            testimonals.setDate_send(LocalDateTime.now());
            log.info("Save testimonals with name {} in {}",testimonals.getName(),new Date());
            testimonalsRepository.saveTestimonals(testimonals);
            return true;
        }else{
            log.error("Cannot save testimonals with equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public boolean deleteTestimonals(Long id) {
        if(id!=null){
            log.info("Delete testimonals with id {} in {}",id,new Date());
            return testimonalsRepository.deleteTestimonals(id);
        }else{
            log.error("Cannot save testimonals with id equals null in {}",new Date());
            return false;
        }
     }

    @Override
    public List<Testimonals> listTestimonals() {
        log.info("Get all testimonals in {}",new Date());
        return testimonalsRepository.listTestimonals();
    }
}
