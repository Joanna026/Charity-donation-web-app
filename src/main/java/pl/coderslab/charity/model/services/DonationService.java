package pl.coderslab.charity.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.entities.Donation;
import pl.coderslab.charity.model.repositories.DonationRepository;
import pl.coderslab.charity.model.DTO.DonationDTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DonationService {

    private final ModelMapper modelMapper;
    private final DonationRepository donationRepository;

    public DonationService(ModelMapper modelMapper, DonationRepository donationRepository) {
        this.modelMapper = modelMapper;
        this.donationRepository = donationRepository;
    }


    public void save(DonationDTO donationDTO) {
        donationRepository.save(toEntity(donationDTO));
    }

    public List<DonationDTO> getAll() {
        List<DonationDTO> donationDtoList = new ArrayList<>();

        for(Donation donation : donationRepository.findAll()) {
            donationDtoList.add(toDto(donation));
        }
        return donationDtoList;
    }

    public void update(DonationDTO donationDTO) {
        donationRepository.save(toEntity(donationDTO));
    }

    public void deleteById(Long id) {
        donationRepository.deleteById(id);
    }

    public Integer getTotalQuantity() {
        return donationRepository.getTotalQuantity();
    }



    private DonationDTO toDto(Donation donation) {
        return modelMapper.map(donation, DonationDTO.class);
    }

    private Donation toEntity(DonationDTO donationDTO) {
        return modelMapper.map(donationDTO, Donation.class);
    }
}
