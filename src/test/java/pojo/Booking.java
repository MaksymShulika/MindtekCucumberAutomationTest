package pojo;
// -> Java Object

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class Booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;


}



/*
{
    "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2023-01-01",
        "checkout": "2023-02-02"
    },
    "additionalneeds": "Breakfast"
}
 */