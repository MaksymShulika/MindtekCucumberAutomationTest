package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class YardData {
    private String location;
    private String status;
    private String address;
    private Integer apt_suite_company_co;
    private String city;
    private String state;
    private Integer zip_code;
    private Integer spots;
    private String warning;
    private String notes;
    private Yard_picture yardPicture;
    private Contacts [] contacts;
    private Service_phone_number servicePhoneNumber;
    private Owner_phone_number owner_phone_number;
}
