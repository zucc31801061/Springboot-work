package cn.edu.zucc.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "ec2", replicas = 0, shards = 5)
@Data
public class Log implements Serializable {
    public Log(String id,String url, String method, String ip, Date date, String param, String admin) {
        this.id = id;
        this.url = url;
        this.method = method;
        this.ip = ip;
        this.date = date;
        this.param = param;
        this.admin = admin;
    }

    private String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String url;

    @Field(type = FieldType.Keyword)
    private String method;

    private String ip;

    private Date date;

    private String param;

    private String admin;
}
