package com.dailyservice.dto;

import java.math.BigInteger;
import java.util.Objects;

/**
 * This class contains all the attributes of a customer.
 *
 * @author Priya Raut
 * @version 1.0
 */
public class CustomerDto {
    private BigInteger customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int apartmentNumber;
    private String area;
    private String optionalAddress;
    private String city;
    private int pinCode;

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOptionalAddress() {
        return optionalAddress;
    }

    public void setOptionalAddress(String optionalAddress) {
        this.optionalAddress = optionalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", area='" + area + '\'' +
                ", optionalAddress='" + optionalAddress + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return apartmentNumber == that.apartmentNumber &&
                pinCode == that.pinCode &&
                customerId.equals(that.customerId) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                phoneNumber.equals(that.phoneNumber) &&
                Objects.equals(area, that.area) &&
                Objects.equals(optionalAddress, that.optionalAddress) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, phoneNumber, apartmentNumber, area, optionalAddress, city, pinCode);
    }
}
