package com.ColdPitch.domain.repository;

import com.ColdPitch.domain.entity.Comment;
import com.ColdPitch.domain.entity.QComment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Comment> findAllByPostId(Long postId) {
        return queryFactory
            .selectFrom(QComment.comment)
            .where(QComment.comment.postId.eq(postId))
            .fetch();
    }
}
