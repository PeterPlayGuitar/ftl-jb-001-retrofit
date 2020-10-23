package com.a_peter0.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponse {
    @Getter
    @Setter
    @ToString
    public static class Geo {
        private String lat;
        private String lng;
    }

    @Getter
    @Setter
    @ToString
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    @Getter
    @Setter
    @ToString
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}
