package org.tesinitsyn.recipefeedrestapi;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "expanses")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expanse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "expanse_name")
    private String name;

    @Column(name = "expanse_description")
    private String description;

    @Column(name = "expanse_type")
    private String type;

    @Column(name = "expanse_value")
    private Integer value;
}
