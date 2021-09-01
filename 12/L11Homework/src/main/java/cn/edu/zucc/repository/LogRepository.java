package cn.edu.zucc.repository;

import cn.edu.zucc.entity.Log;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LogRepository extends ElasticsearchRepository<Log, String> {

    List<Log> findAllByAdmin( String admin);
    Log findByAdmin(String admin);

}