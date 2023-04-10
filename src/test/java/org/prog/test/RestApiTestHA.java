package org.prog.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.prog.api.dto.SearchResultsDto;
import org.prog.api.dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class RestApiTestHA {
    public final static String URL = "https://randomuser.me/api/?inc=gender,name,nat,login&noinfo&results=%s";

    @Test
    public void apiTest() {
        RequestSpecification rs = RestAssured.given();
        Response response = rs.get(getUsers(100));

        SearchResultsDto searchResultsDto = response.as(SearchResultsDto.class);
        List<String> male = searchResultsDto
                .getResults()
                .stream()
                .filter(userDto -> userDto.getGender().equals("male"))
                .map(UserDto::getNat)
                .collect(Collectors.toList());
        List<String> female = searchResultsDto
                .getResults()
                .stream()
                .filter(userDto -> userDto.getGender().equals("female"))
                .map(UserDto::getNat)
                .collect(Collectors.toList());

        boolean match = false;
        for (String maleNat: male) {
            if (female.contains(maleNat)) {
                match = true;
                break;
            }
        }
        Assert.assertTrue(match);
    }

    private String getUsers(int amount) {
        return String.format(URL, amount);
    }

}


