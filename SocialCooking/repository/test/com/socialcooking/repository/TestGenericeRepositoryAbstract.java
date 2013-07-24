package com.socialcooking.repository;


import com.socialcooking.domain.DomainObject;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration(locations = {"classpath:"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class TestGenericeRepositoryAbstract<T extends DomainObject> {

}
