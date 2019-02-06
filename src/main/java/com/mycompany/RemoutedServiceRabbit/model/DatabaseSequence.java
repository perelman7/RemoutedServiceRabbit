package com.mycompany.RemoutedServiceRabbit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "databaseSequence")
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DatabaseSequence implements Serializable {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter @Setter
    private long seq;
}
