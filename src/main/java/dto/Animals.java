package dto;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public /*abstract*/ class Animals {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String type;
  private String name;
}
