package com.firstdemo.core.models;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.inject.Inject;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = UserList.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserListImpl implements UserList{
    @Inject
    ResourceResolver resolver;
    @Inject
    QueryBuilder queryBuilder;

    @OSGiService
    ResourceResolverFactory resourceResolverFactory;

    @Override
    public String getUserName() {

            String user="";
            List<String> usernames = new ArrayList<>();
            Map<String, String> userMap = new HashMap<>();
            userMap.put("p.hits", "selective");
            userMap.put("p.limit", "-1");
            userMap.put("property", "jcr:primaryType");
            userMap.put("property.value", "rep:User");
            userMap.put("path", "/home/users");
            userMap.put("type", "rep:User");
            userMap.put("p.properties", "rep:principalName");
            try (ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory)){

                Session session = resolver.adaptTo(Session.class);
                Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
                SearchResult result = userQuery.getResult();
                List<Hit> Hits = result.getHits();
                for (Hit hit : Hits) {
                    user = user + "\r\n" + hit.getProperties().get("rep:principalName", String.class);

                }
            } catch (Exception e) {

            }
            return user;
        }

    }

