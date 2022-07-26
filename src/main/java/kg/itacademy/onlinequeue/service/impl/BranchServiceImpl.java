package kg.itacademy.onlinequeue.service.impl;

import kg.itacademy.onlinequeue.entity.BranchEntity;
import kg.itacademy.onlinequeue.mapper.BranchMapper;
import kg.itacademy.onlinequeue.model.BranchModel;
import kg.itacademy.onlinequeue.model.CompanyModel;
import kg.itacademy.onlinequeue.repository.BranchRepository;
import kg.itacademy.onlinequeue.service.BranchService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchServiceImpl implements BranchService {

    final BranchRepository branchRepository;

    @Override
    public BranchModel create(BranchModel branchModel) {

        BranchEntity branchEntity = BranchMapper.INSTANCE.toEntity(branchModel);
        return BranchMapper.INSTANCE.toModel(branchRepository.save(branchEntity));
    }

    @Override
    public boolean update(BranchModel branchModel) {

        BranchEntity branchEntity = BranchMapper.INSTANCE.toEntity(branchModel);
        return branchRepository.save(branchEntity).getId() != null;
    }

    @Override
    public BranchModel getByBranchName(String branchName) {
        return BranchMapper.INSTANCE.toModel(branchRepository.getByName(branchName));
    }

    @Override
    public boolean delete(BranchModel branchModel) {
        try {
            branchRepository.delete(branchRepository.getByName(branchModel.getName()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<BranchEntity> getAllBranch() {
        return branchRepository.findAll();
    }
}
