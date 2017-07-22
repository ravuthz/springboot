package com.ravuthz.springboot.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;

/**
 * Created by Vannaravuth Yo
 * Date : 7/22/17, 11:48 PM
 * Email : ravuthz@gmail.com
 */

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {

    @Autowired
    private Validator validator;

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
    }
}
