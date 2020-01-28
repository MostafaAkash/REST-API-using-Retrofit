package com.example.myapp.Model;

import com.example.myapp.Model.Person;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("search_found")
    private int searchNumber;
    @SerializedName("error")
    private int errorNumber;
    @SerializedName("error_report")
    private String errorReport;
    @SerializedName("search_result")
    private List<Person>persons = null;

    public Search(int searchNumber, int errorNumber, String errorReport, List<Person> persons) {
        this.searchNumber = searchNumber;
        this.errorNumber = errorNumber;
        this.errorReport = errorReport;
        this.persons = persons;
    }

    public int getSearchNumber() {

        return searchNumber;
    }

    public void setSearchNumber(int searchNumber) {
        this.searchNumber = searchNumber;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public void setErrorReport(String errorReport) {
        this.errorReport = errorReport;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
