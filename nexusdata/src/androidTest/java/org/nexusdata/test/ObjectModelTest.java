package com.github.dkharrat.nexusdata.test;

import junit.framework.TestCase;
import com.github.dkharrat.nexusdata.metamodel.ObjectModel;

public class ObjectModelTest extends TestCase {

    ObjectModel model;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        model = new ObjectModel(getClass().getResourceAsStream("/assets/company.model.json"));
    }

    @Override
    protected void tearDown() throws Exception {
        model = null;

        super.tearDown();
    }

    public void testGetEntities() throws Throwable {
        assertEquals(3, model.getEntities().size());
        //TODO: order of entities not guaranteed; so the following tests may intermittently fail
        assertEquals(Company.class.getSimpleName(),  model.getEntities().get(0).getName());
        assertEquals(Employee.class.getSimpleName(), model.getEntities().get(1).getName());
    }

    public void testGetEntity() throws Throwable {
        assertEquals(Company.class.getSimpleName(),  model.getEntity(Company.class).getName());
    }
}
