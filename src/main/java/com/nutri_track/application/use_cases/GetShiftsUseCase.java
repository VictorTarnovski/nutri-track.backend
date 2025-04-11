package com.nutri_track.application.use_cases;

import com.nutri_track.domain.dtos.GetShiftsDto;
import com.nutri_track.domain.entities.Shift;
import com.nutri_track.domain.repositories.ShiftRepository;
import com.nutri_track.domain.specifications.ShiftIsNotNullSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GetShiftsUseCase {
    private final ShiftRepository shiftRepository;

    public GetShiftsUseCase(ShiftRepository shiftRepository) {
       this.shiftRepository = shiftRepository;
    }

    public Page<Shift> execute(GetShiftsDto dto) {
        var spec = new ShiftIsNotNullSpecification();
        var pageable = PageRequest.of(dto.page(), dto.pageSize());
        return shiftRepository.findAll(spec, pageable);
    }
}
