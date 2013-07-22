package com.socialcooking.repository.api;

import com.socialcooking.domain.Section;

import java.util.List;

/**
 * @author Mikalai Kisel
 */

public interface SectionRepository extends IGenericRepository<Section> {


    //TODO переопределить методы у которых в параметрах передается id (т.к. здесь тип id - String)

    public Section findById(String name);

    public List<Section> findAll();

    public Section save(Section section);

    public Section update(Section section);

    public void delete(Section section);

}
