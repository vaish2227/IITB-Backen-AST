package com.courses.IITB.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateinstanceRequest {
    private int courseId;
    private int  courseYear;
    private int courseSem;
}
