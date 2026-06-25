package com.rapido.platformservice;

import com.rapido.platformcommon.dto.ApiResponse;

public class CommonLibraryTest {

    public void test() {

        ApiResponse<String> response =
                new ApiResponse<>(true, "Library Imported Successfully", "SUCCESS");

        System.out.println(response.getMessage());
    }
}