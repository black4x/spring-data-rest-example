package com.example.tenant.config;

import java.util.Collections;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DisableSelfLink {

    /**
     * replaces the method called in spring for creating links
     *
     * @return empty links
     * @throws Throwable
     */
    @Around(value = "execution(* org.springframework.data.rest.webmvc.mapping.LinkCollector.getLinksFor(..))")
    public Object stopCreatingLinks() throws Throwable {
        return new Links(Collections.<Link>emptyList());
    }

}
