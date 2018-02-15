package org.qbit.datasource.demo.db1;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "table1")
public class Table1 {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

}
