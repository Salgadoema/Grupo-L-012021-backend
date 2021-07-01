package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.ContentDTO;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.ReverseSearchDTO;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.ContentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    private void SlowService() {
        try {
            long time = 4000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


    @Autowired
    public ContentPersistence repository;


    public Content findById(Integer id) { return repository.findById(id).get(); }

    @Cacheable("ContentByTitle")
    public ContentDTO findByContentTitle(String title) {
        SlowService();
        Content basicDataContent = repository.findByPrimaryTitle(title).get();
        ContentDTO basicDataContentDTO= new ContentDTO();
        basicDataContentDTO.setOriginalTitle(basicDataContent.getOriginalTitle());
        basicDataContentDTO.setPrimaryTitle(basicDataContent.getPrimaryTitle());
        basicDataContentDTO.setAverage(basicDataContent.getAverageReviewScore());
        basicDataContentDTO.setReviewsQty(basicDataContent.getReviews().size());
        return basicDataContentDTO;
    }



    public List<Content> findAll() {
        return repository.findAll(); }



    public List<Content> findAll(ReverseSearchDTO searchDTO) {

        return repository.findAll(searchDTO.getContentType(), searchDTO.getContentStartYear(),
                searchDTO.getContentEndYear(), searchDTO.getCrewMemberName(), searchDTO.getGenre(),
                searchDTO.getRating(), searchDTO.getOnlyLikedReviews(), searchDTO.getPageNumber(),
                searchDTO.getPageSize()); }
}
