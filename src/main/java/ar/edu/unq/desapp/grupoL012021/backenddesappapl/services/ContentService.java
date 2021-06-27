package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.ReverseSearchDTO;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.ContentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    public ContentPersistence repository;

    //@Cacheable("content")
    public Content findById(Integer id) { return repository.findById(id).get(); }

    public List<Content> findAll() { return repository.findAll(); }

    public List<Content> findAll(ReverseSearchDTO searchDTO) {

        return repository.findAll(searchDTO.getContentType(), searchDTO.getContentStartYear(),
                searchDTO.getContentEndYear(), searchDTO.getCrewMemberName(), searchDTO.getGenre(),
                searchDTO.getRating(), searchDTO.getOnlyLikedReviews(), searchDTO.getPageNumber(),
                searchDTO.getPageSize()); }
}
