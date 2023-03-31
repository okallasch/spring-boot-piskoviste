package org.gopas.springbootdemo.api;

import java.time.LocalDate;

public class PersonDetailedViewDto {
    private Long id;
    private int age;
    private LocalDate birthday;
    private String email;
    private String nickname;
    private PersonAddressDto address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public PersonAddressDto getAddress() {
        return address;
    }

    public void setAddress(PersonAddressDto address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonDetailedViewDto{" +
                "id=" + id +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", address=" + address +
                '}';
    }
}
