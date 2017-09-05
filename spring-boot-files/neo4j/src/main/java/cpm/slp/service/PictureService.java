package cpm.slp.service;

import cpm.slp.domain.Picture;
import cpm.slp.model.PictureQo;
import cpm.slp.repository.PictureRepository;
import org.springframework.stereotype.Service;
import org.neo4j.ogm.cypher.BooleanOperator;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
/**
 * Created by sangliping on 2017/9/4.
 */
@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private PagesService<Picture> pagesService;

    public Picture findById(Long id) {
        return pictureRepository.findOne(id);
    }

    public Picture create(Picture picture) {
        return pictureRepository.save(picture);
    }

    public Picture update(Picture picture) {
        return pictureRepository.save(picture);
    }

    public void delete(Long id) {
        Picture picture = pictureRepository.findOne(id);
        pictureRepository.delete(picture);
    }

    public Picture findByName(String name){
        return pictureRepository.findByFileName(name);
    }

    public void delete(Picture picture){
        pictureRepository.delete(picture);
    }

    public Iterable<Picture> findAll(){
        return pictureRepository.findAll();
    }

    public Page<Picture> findPage(PictureQo pictureQo){
        Pageable pageable = new PageRequest(pictureQo.getPage(), pictureQo.getSize(), new Sort(Sort.Direction.ASC, "id"));

        Filters filters = new Filters();
        if (!StringUtils.isEmpty(pictureQo.getFileName())) {
            Filter filter = new Filter("name", pictureQo.getFileName());
            filters.add(filter);
        }
        if (!StringUtils.isEmpty(pictureQo.getShopid())) {
            Filter filter = new Filter("shopid", pictureQo.getShopid());
            filter.setComparisonOperator(ComparisonOperator.EQUALS);
            filter.setBooleanOperator(BooleanOperator.AND);
            filters.add(filter);
        }

        return pagesService.findAll(Picture.class, pageable, filters);
    }
}
