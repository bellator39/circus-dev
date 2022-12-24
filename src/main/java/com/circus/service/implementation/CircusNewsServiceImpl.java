package com.circus.service.implementation;

import com.circus.domain.CircusNews;
import com.circus.domain.TagNews;
import com.circus.repository.api.CircusNewsRepositoryApi;
import com.circus.service.api.CircusNewsServiceApi;
import com.circus.service.api.TagNewsServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CircusNewsServiceImpl implements CircusNewsServiceApi {

    private final CircusNewsRepositoryApi circusNewsRepository;
    private final TagNewsServiceApi tagNewsService;

    @Override
    public boolean saveCircusNews(CircusNews circusNewsSave) {
        if(circusNewsSave!=null){
            log.info("Save circus news with service, with name {} in {}",circusNewsSave.getNewsName(),new Date());
            return circusNewsRepository.saveCircusNews(circusNewsSave);
        }else{
            log.error("Cannot save circus news, equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public boolean updateCircusNews(CircusNews circusNewsUpdate) {
        if(circusNewsUpdate.getId()!=null){
            log.info("Update circus news with service, with id {} in {}",circusNewsUpdate.getId(),new Date());
            return circusNewsRepository.updateCircusNews(circusNewsUpdate);
        }else{
            log.error("Cannot update circus news, id equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public CircusNews getCircusNewsById(Long idCircusNews) {
        if(idCircusNews!=null){
            log.info("Get circus news by id with service, with id {} in {}",idCircusNews,new Date());
            return circusNewsRepository.getCircusNewsById(idCircusNews);
        }else{
            log.error("Cannot get circus news by id, id equals null in {}",new Date());
            return null;
        }
    }

    @Override
    public List<CircusNews> findAllCircusNews() {
        log.info("Get all circus news in {}",new Date());
        return circusNewsRepository.findAllCircusNews();
    }

    @Override
    public boolean deleteCircusNews(Long idCircusNews) {
        if(idCircusNews!=null){
            log.info("Delete circus news by id with service, with id {} in {}",idCircusNews,new Date());
            return circusNewsRepository.deleteCircusNews(idCircusNews);
        }else{
            log.error("Cannot delete circus news by id, id equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public List<CircusNews> findAllByTag(TagNews tagNews) {
        TagNews tagNewsCheck = tagNewsService.findAllTagNews().stream().
                filter(o1->o1.getTagName().equals(tagNews.getTagName())).findFirst().orElse(null);
        if(tagNewsCheck!=null){
            log.info("Get all circus news by tag with service, with tag {} in {}",tagNews.getId(),new Date());
            return circusNewsRepository.findAllByTag(tagNews);
        }else{
            log.error("Cannot delete circus news by tag, tag equals null in {}",new Date());
            return null;
        }
    }
}
