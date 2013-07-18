package com.socialcooking.repository;

import com.socialcooking.domain.Section;

import java.util.List;

/**
 * @author Mikalai Kisel
 */

public interface SectionRepository {

    public List<Section> findAll();


}
