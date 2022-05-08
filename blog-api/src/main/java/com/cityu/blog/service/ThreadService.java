package com.cityu.blog.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cityu.blog.dao.mapper.ArticleMapper;
import com.cityu.blog.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    @Async("taskExcutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {

        int viewCounts = article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(viewCounts + 1);
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        //为了在多线程环境下线程安全
        updateWrapper.eq(Article::getViewCounts, viewCounts);
        articleMapper.update(articleUpdate, updateWrapper);
        //期望此操作在线程池中执行，不会影响主线程
        try {
            Thread.sleep(5000);
            System.out.println("更新完成了");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
