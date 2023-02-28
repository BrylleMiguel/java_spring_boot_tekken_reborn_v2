package com.cpan252.tekkenreborn.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FighterSearchByDateDTO {
    private String name;
    private String startDate;
    private String endDate;

}