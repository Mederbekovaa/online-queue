package kg.itacademy.onlinequeue.mapper;

import kg.itacademy.onlinequeue.entity.BranchEntity;
import kg.itacademy.onlinequeue.model.BranchModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BranchMapper {

    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    BranchEntity toEntity(BranchModel branchModel);

    BranchModel toModel(BranchEntity branchEntity);

    List<BranchModel> toBranchModels(List<BranchEntity> branchEntityList);
}
