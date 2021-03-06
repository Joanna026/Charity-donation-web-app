package pl.coderslab.charity.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.entities.Institution;
import pl.coderslab.charity.model.repositories.InstitutionRepository;
import pl.coderslab.charity.model.DTO.InstitutionDTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstitutionService {

    private final ModelMapper modelMapper;
    private final InstitutionRepository institutionRepository;


    public InstitutionService(ModelMapper modelMapper, InstitutionRepository institutionRepository) {
        this.modelMapper = modelMapper;
        this.institutionRepository = institutionRepository;
    }

    public void save(InstitutionDTO institutionDTO) {
        institutionRepository.save(toEntity(institutionDTO));
    }

    public List<InstitutionDTO> getAll() {
        List<InstitutionDTO> institutionDtoList = new ArrayList<>();

        for (Institution institution : institutionRepository.findAllByArchivedFalse()) {
            institutionDtoList.add(toDto(institution));
        }
        return institutionDtoList;
    }

    public void softDeleteById(Long id) {
        Optional<Institution> institutionToDelete = institutionRepository.findById(id);
        institutionToDelete.ifPresent(institution -> {
            institution.setArchived(true);
            institutionRepository.save(institution);
        });
    }

    public void update(InstitutionDTO institutionDTO) {

        Optional<Institution> institutionToEdit = institutionRepository.findById(institutionDTO.getId());
        institutionToEdit.ifPresent(institution -> {
            institution.setName(institutionDTO.getName());
            institution.setDescription(institutionDTO.getDescription());
            institution.setArchived(false);
            institutionRepository.save(institution);
        });

    }

    public void deleteById(Long id) {
        institutionRepository.deleteById(id);
    }

    public Optional<Integer> countAllInstitutions() {
        return institutionRepository.countAllByInstitution();
    }

    private InstitutionDTO toDto(Institution institution) {
        return modelMapper.map(institution, InstitutionDTO.class);
    }

    private Institution toEntity(InstitutionDTO institutionDTO) {
        return modelMapper.map(institutionDTO, Institution.class);
    }


    public InstitutionDTO getById(Long institutionId) {
        return toDto(institutionRepository.findById(institutionId).orElseGet(() -> {
            return null;
        }));
    }
}