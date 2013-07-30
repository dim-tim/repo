package com.socialcooking.service;

import com.socialcooking.domain.DomainObject;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractGenericServiceMockTest<T extends DomainObject> {

    protected abstract GenericService<T> getService();

    protected abstract GenericRepository<T> getMockRepository();

    protected abstract T getEntity();

    @Test
    public void testSave() {
        when(getMockRepository().save(getEntity())).thenReturn(getEntity());

        T testReturnEntity = getService().save(getEntity());

        assertNotNull(testReturnEntity);
        assertTrue(testReturnEntity.getId() == getEntity().getId());
    }

    @Test
    public void testDeleteById() {
        getService().deleteById(getEntity().getId());
        verify(getMockRepository()).deleteById(getEntity().getId());
    }

    @Test
    public void testDelete() {
        getService().delete(getEntity());
        verify(getMockRepository()).delete(getEntity());
    }

    @Test
    public void testDeleteAll() {
        getService().deleteAll();
        verify(getMockRepository()).deleteAll();
    }

    @Test
    public void testFindById() {
        when(getMockRepository().findById(getEntity().getId())).thenReturn(getEntity());

        T testReturnEntity = getService().findById(getEntity().getId());

        assertNotNull(testReturnEntity);
        assertTrue(testReturnEntity.getId() == getEntity().getId());
    }

    @Test
    public void testFindAll() {
        List<T> list = new ArrayList<T>();
        list.add(getEntity());
        when(getMockRepository().findAll()).thenReturn(list);

        List<T> testReturnEntityList = getService().findAll();

        assertNotNull(testReturnEntityList);
        assertTrue(testReturnEntityList.size() > 0);
        assertTrue(testReturnEntityList.get(0).getId() == list.get(0).getId());
    }

    @Test
    public void testCount() {
        when(getMockRepository().count()).thenReturn((long) 1);
        long returnCount = getService().count();
        assertTrue(returnCount == 1);
    }
}
