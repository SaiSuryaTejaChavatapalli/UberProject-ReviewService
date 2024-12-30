package com.sst.UberReviewService.adapters;

import com.sst.UberReviewService.dtos.CreateReviewDto;
import com.sst.UberReviewService.models.Review;

public interface CreateReviewDtoToReviewAdapter {

    public Review convertDto(CreateReviewDto createReviewDto);

}
