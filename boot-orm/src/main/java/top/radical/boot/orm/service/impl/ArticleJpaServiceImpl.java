package top.radical.boot.orm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.radical.boot.orm.dao.ArticleRepository;
import top.radical.boot.orm.entity.Article;
import top.radical.boot.orm.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author : radical
 * @description :
 * @data : 2022/3/18
 **/
@Service
public class ArticleJpaServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void deleteById(int id) {
        articleRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public List<Article> selectAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {
        Optional<Article> optional = articleRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Article> findByAuthor(String author) {
        return articleRepository.findByAuthor(author);
    }
}
