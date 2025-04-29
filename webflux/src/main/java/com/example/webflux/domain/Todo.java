package com.example.webflux.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo implements Persistable<Integer> {

    @Id
    private Integer id;

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Transient
    @Builder.Default
    @JsonIgnore
    private boolean isNewEntry = true;

    // This method checks if the record is new

    @JsonIgnore
    public boolean isNew() {
        return isNewEntry;
    }
}
