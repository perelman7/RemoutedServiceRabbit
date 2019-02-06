package com.mycompany.RemoutedServiceRabbit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "changeRow")
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ChangeRow implements Serializable {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String tableName;

    @Getter @Setter
    private String methodName;

    @Getter @Setter
    private String oldValue;

    @Getter @Setter
    private String newValue;

    @Getter @Setter
    private int version;

    @Getter @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateChange;
}
