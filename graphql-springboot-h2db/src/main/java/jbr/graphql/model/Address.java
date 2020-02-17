package jbr.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  @Column(name = "stud_id", nullable = false)
  private Long id;

  @Column(name = "street", nullable = false)
  private String street;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "pincode", nullable = false)
  private Long pincode;
}
