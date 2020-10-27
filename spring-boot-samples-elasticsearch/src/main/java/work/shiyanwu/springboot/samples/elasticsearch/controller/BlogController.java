package work.shiyanwu.springboot.samples.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.shiyanwu.springboot.samples.elasticsearch.entity.Blog;
import work.shiyanwu.springboot.samples.elasticsearch.repository.BlogRepository;

import java.util.*;

/**
 * @author shiYanWu
 */
@RestController
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @RequestMapping("save")
    public Blog save() {
        Blog blog = new Blog();
        blog.setId(System.currentTimeMillis());
        blog.setTitle("测试标题");
        Set<String> tags = new HashSet<>();
        tags.add("Java");
        tags.add("Python");
        blog.setTags(tags);
        blog.setContent("今天天气不错");
        return blogRepository.save(blog);
    }

    @RequestMapping("list")
    public List<Blog> list() {
        List<Blog> list = new ArrayList<>();
        Iterable<Blog> iterable = blogRepository.findAll();
        Iterator<Blog> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
