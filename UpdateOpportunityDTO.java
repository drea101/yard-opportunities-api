package edu.famu.cop3060.yard.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class UpdateOpportunityDTO {

    @NotBlank(message = "Title is required")
    @Size(max = 120, message = "Title must be 120 characters or fewer")
    private String title;

    @NotBlank(message = "Type is required")
    @Pattern(
        regexp = "Scholarship|Internship|Organization|Event|Fellowship",
        message = "Type must be one of: Scholarship, Internship, Organization, Event, Fellowship"
    )
    private String type;

    @NotBlank(message = "Sponsor is required")
    private String sponsor;

    @NotBlank(message = "Deadline is required")
    private String deadline;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description must be 500 characters or fewer")
    private String description;

    @NotNull(message = "Tags are required")
    @Size(min = 1, message = "At least one tag is required")
    private List<String> tags;

    @NotBlank(message = "URL is required")
    @org.hibernate.validator.constraints.URL(message = "URL must be a valid web address")
    private String url;

    // Getters and Setters
}
