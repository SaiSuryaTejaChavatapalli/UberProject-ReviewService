package com.sst.UberReviewService.adapters;

import com.sst.UberReviewService.dtos.CreateReviewDto;
import com.sst.UberReviewService.models.Booking;
import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements  CreateReviewDtoToReviewAdapter{

    final private BookingRepository bookingRepository;


    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }


    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        System.out.println("createDtobId"+createReviewDto.getBookingId());
        Optional<Booking> booking= bookingRepository.findById(createReviewDto.getBookingId());
        System.out.println("convertDto"+booking);
        if(booking.isEmpty()){
            return null;
        }
        Review review=Review.builder().
                rating(createReviewDto.getRating()).
                booking(booking.get()).
                content(createReviewDto.getContent()).
                build();

        System.out.println("Review in convertDto: "+review);
        return  review;
    }
}
