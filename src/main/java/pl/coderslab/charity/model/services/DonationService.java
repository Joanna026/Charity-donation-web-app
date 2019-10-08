package pl.coderslab.charity.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.DTO.DonationDTO;
import pl.coderslab.charity.model.entities.Donation;
import pl.coderslab.charity.model.repositories.DonationRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DonationService {

    private final ModelMapper modelMapper;
    private final DonationRepository donationRepository;

    public DonationService(ModelMapper modelMapper, DonationRepository donationRepository) {
        this.modelMapper = modelMapper;
        this.donationRepository = donationRepository;
    }


    public void save(DonationDTO DonationDTO) {
        donationRepository.save(toEntity(DonationDTO));
    }

    public List<DonationDTO> getAll() {
        List<DonationDTO> DonationDtoList = new ArrayList<>();

        for(Donation donation : donationRepository.findAll()) {
            DonationDtoList.add(toDto(donation));
        }
        return DonationDtoList;
    }

    public void update(DonationDTO DonationDTO) {
        donationRepository.save(toEntity(DonationDTO));
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

    private Donation toEntity(DonationDTO DonationDTO) {
        return modelMapper.map(DonationDTO, Donation.class);
    }
}
