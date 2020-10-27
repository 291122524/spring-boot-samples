package work.shiyanwu.springboot.samples.elasticsearch.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author shiYanWu
 */
@Data
@Document(indexName = "blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Field(type = FieldType.Long)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Field(type = FieldType.Keyword)
    private Set<String> tags;

    @Field(type = FieldType.Long)
    private String title;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Date)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}
