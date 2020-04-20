package com.legoons.consultantms.repository;

import com.legoons.consultantms.dto.SearchRequest;
import com.legoons.consultantms.entity.Consultant;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends PagingAndSortingRepository<Consultant, Long>, QuerydslPredicateExecutor<Consultant> {

    static BooleanBuilder createSearchPredicate(SearchRequest request) {

        BooleanBuilder predicate = new BooleanBuilder();

//        if (request.getEmail() != null) {
//            predicate.and(QConsultant.consultant.email.startsWithIgnoreCase(request.getEmail()));
//        }

        return predicate;
    }
}
