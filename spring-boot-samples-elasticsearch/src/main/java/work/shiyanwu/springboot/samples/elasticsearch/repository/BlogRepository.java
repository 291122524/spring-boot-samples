package work.shiyanwu.springboot.samples.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import work.shiyanwu.springboot.samples.elasticsearch.entity.Blog;

/**
 * @author shiYanWu
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, Long> {
}
