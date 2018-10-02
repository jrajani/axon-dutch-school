package io.blueharvest.labs.axon.query.model;

import io.blueharvest.labs.axon.common.model.*;
import io.blueharvest.labs.axon.common.query.CountCoursesQuery;
import io.blueharvest.labs.axon.common.query.CountCoursesResponse;
import io.blueharvest.labs.axon.common.query.FindCoursesQuery;
import io.blueharvest.labs.axon.common.query.FindCoursesResponse;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CourseSummaryProjection {

    private final List<CourseSummary> courseSummaries = new CopyOnWriteArrayList<CourseSummary>();

    private final EntityManager entityManager;

    public CourseSummaryProjection(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @QueryHandler
    public FindCoursesResponse handle(FindCoursesQuery query) {
        Query jpaQuery = entityManager.createQuery("SELECT c FROM CourseSummary c ORDER BY c.id", CourseSummary.class);
        jpaQuery.setFirstResult(query.getOffset());
        jpaQuery.setMaxResults(query.getLimit());
        FindCoursesResponse response = new FindCoursesResponse(jpaQuery.getResultList());
        return response;
    }

    @QueryHandler
    public CountCoursesResponse handle(CountCoursesQuery query) {
        Query jpaQuery = entityManager.createQuery("SELECT COUNT(c) FROM CourseSummary c", Long.class);
        CountCoursesResponse response = new CountCoursesResponse(((Long) jpaQuery.getSingleResult()).intValue());
        return response;
    }
}
