package com.circus.service;

import com.circus.domain.TagNews;
import com.circus.repository.api.TagNewsRepositoryApi;
import com.circus.service.api.TagNewsServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TagNewsServiceImpl implements TagNewsServiceApi {

    private final TagNewsRepositoryApi tagNewsRepository;

    @Override
    public boolean saveTag(TagNews tagNewsSave) {
        if(!tagNewsSave.getTagName().equals("")){
            log.info("Save tag with services, name {} in {}",tagNewsSave.getTagName(), new Date());
            return tagNewsRepository.saveTag(tagNewsSave);
        }else {
            log.error("Cannot save tag, tag name equals empty");
            return false;
        }
    }

    @Override
    public boolean updateTag(TagNews tagNewsUpdate) {
        if(tagNewsUpdate.getId()!=null && !tagNewsUpdate.getTagName().equals("")){
            log.info("Save tag with services, id {} in {}",tagNewsUpdate.getId(), new Date());
            return tagNewsRepository.updateTag(tagNewsUpdate);
        }else {
            log.error("Cannot save tag, id tag equals null");
            return false;
        }
    }

    @Override
    public List<TagNews> findAllTagNews() {
        log.info("Get all tags with services in {}",new Date());
        return tagNewsRepository.findAllTagNews();
    }

    @Override
    public boolean deleteTagNews(Long idTagNews) {
        if(idTagNews!=null){
            log.info("Delete tag with service, id {} in {}",idTagNews, new Date());
            return tagNewsRepository.deleteTagNews(idTagNews);
        }else{
            log.error("Cannot delete tag, id equals null in {}",new Date());
            return false;
        }
    }
}
