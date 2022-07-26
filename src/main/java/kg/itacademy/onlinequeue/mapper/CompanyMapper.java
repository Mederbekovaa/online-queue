package kg.itacademy.onlinequeue.mapper;

import kg.itacademy.onlinequeue.entity.CompanyEntity;
import kg.itacademy.onlinequeue.model.CompanyModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyEntity toEntity(CompanyModel companyModel);

    CompanyModel toModel(CompanyEntity companyEntity);

    List<CompanyModel> toCompanyModels(List<CompanyEntity> companyEntityList);


}
