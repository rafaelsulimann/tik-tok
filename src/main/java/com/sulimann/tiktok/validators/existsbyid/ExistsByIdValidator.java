package com.sulimann.tiktok.validators.existsById;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsByIdValidator implements ConstraintValidator<ExistsById, Object>{

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsById params){
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(Objects.isNull(value)){
            return true;
        }
        Query query = this.manager.createQuery("SELECT 1 FROM " + this.klass.getName() + " WHERE " + this.domainAttribute + "=:value");
        query.setParameter("value", value);
        return !query.getResultList().isEmpty();
    }

}

