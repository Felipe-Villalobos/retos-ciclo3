package com.rentcloud.app.reports;

import com.rentcloud.app.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountClient {

    private Long total;
    private Client client;
}
