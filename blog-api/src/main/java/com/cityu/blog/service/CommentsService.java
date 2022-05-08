package com.cityu.blog.service;

import com.cityu.blog.vo.Result;
import com.cityu.blog.vo.params.CommentParam;

public interface CommentsService {

    /**
     * 根据文章id 查询所有评论列表
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
