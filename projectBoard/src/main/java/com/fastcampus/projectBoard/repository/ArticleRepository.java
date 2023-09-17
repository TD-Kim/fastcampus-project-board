package com.fastcampus.projectBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fastcampus.projectBoard.domain.Article;
import com.fastcampus.projectBoard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;

@RepositoryRestResource
public interface ArticleRepository extends 
        JpaRepository<Article, Long>, 
        QuerydslPredicateExecutor<Article>, 
        QuerydslBinderCustomizer<QArticle> {

    // QuerydslPredicateExecutor 기본적으로 Entity 안에 있는 모든필드에 대한 검색기능을 추가해준다.
    // QuerydslBinderCustomizer 의 제네릭은 Q 클래스를 넣어준다.

    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title, root.hashtag, root.createdAt, root.createdBy);
        // bindings.bind(root.content).first(StringExpression::likeIgnoreCase);  // like '${v}'
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);  // like '%${v}'
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);  // like '%${v}'
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);

    }   
    
}
