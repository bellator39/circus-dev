package com.circus.repository.api;

import com.circus.domain.Testimonals;

import java.util.List;

public interface TestimonalsRepositoryApi {
    boolean saveTestimonals(Testimonals testimonals);
    boolean deleteTestimonals(Long id);
    List<Testimonals>listTestimonals();
}
