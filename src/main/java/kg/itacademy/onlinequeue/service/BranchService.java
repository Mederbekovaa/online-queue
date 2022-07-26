package kg.itacademy.onlinequeue.service;

import kg.itacademy.onlinequeue.entity.BranchEntity;
import kg.itacademy.onlinequeue.model.BranchModel;

import java.util.List;

public interface BranchService {
    BranchModel create(BranchModel branchModel);

    boolean update(BranchModel branchModel);

    boolean delete(BranchModel branchModel);

    List<BranchEntity> getAllBranch();

    BranchModel getByBranchName(String branchName);
}
