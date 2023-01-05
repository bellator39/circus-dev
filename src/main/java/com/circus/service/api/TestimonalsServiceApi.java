package com.circus.service.api;


import com.circus.domain.Testimonals;

import java.util.List;

public interface TestimonalsServiceApi {
    boolean saveTestimonals(Testimonals testimonals);
    boolean deleteTestimonals(Long id);
    List<Testimonals> listTestimonals();
}
