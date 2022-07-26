package kg.itacademy.onlinequeue.service.impl;

import kg.itacademy.onlinequeue.entity.CompanyEntity;
import kg.itacademy.onlinequeue.entity.UslugaEntity;
import kg.itacademy.onlinequeue.mapper.BranchMapper;
import kg.itacademy.onlinequeue.mapper.CompanyMapper;
import kg.itacademy.onlinequeue.mapper.UslugaMapper;
import kg.itacademy.onlinequeue.model.CompanyModel;
import kg.itacademy.onlinequeue.repository.CompanyRepository;
import kg.itacademy.onlinequeue.service.CompanyService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyServiceImpl implements CompanyService {
       final CompanyRepository companyRepository;

    @Override
    public CompanyModel create(CompanyModel companyModel) {

        CompanyEntity companyEntity = CompanyMapper.INSTANCE.toEntity(companyModel);
        return CompanyMapper.INSTANCE.toModel(companyRepository.save(companyEntity));
    }
    @Override
    public boolean update(CompanyModel companyModel) {

        CompanyEntity companyEntity = CompanyMapper.INSTANCE.toEntity(companyModel);
        return companyRepository.save(companyEntity).getId() != null;
    }

    @Override
    public CompanyModel getByCompanyName(String companyName) {
        return CompanyMapper.INSTANCE.toModel(companyRepository.getByName(companyName));
    }

    @Override
    public boolean delete(CompanyModel companyModel) {
        try {
            companyRepository.delete(companyRepository.getByName(companyModel.getName()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<CompanyModel> getAll() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll();
        List<CompanyModel> companyModelList = new ArrayList<>();
        return  companyModelList;
    }
}

