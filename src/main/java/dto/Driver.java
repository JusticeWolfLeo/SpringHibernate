package dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Driver {
  @Column(name = "driver_name", length = 30)
  private String firstName;
  private String lastName;
  private String middleName;
  private String dateOfBirth;
  private String state_registration;
  private String PTS_auto;
  private String date_PTS;
  private String STS;
  private String date_STS;
}
