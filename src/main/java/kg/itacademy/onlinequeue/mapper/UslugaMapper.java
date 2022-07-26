package kg.itacademy.onlinequeue.mapper;

import kg.itacademy.onlinequeue.entity.BranchEntity;
import kg.itacademy.onlinequeue.entity.UslugaEntity;
import kg.itacademy.onlinequeue.model.BranchModel;
import kg.itacademy.onlinequeue.model.UslugaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UslugaMapper {
    UslugaMapper INSTANCE = Mappers.getMapper(UslugaMapper.class);

    UslugaEntity toEntity(UslugaModel uslugaModel);

    UslugaModel toModel(UslugaEntity uslugaEntity);

    List<UslugaModel> toUslugaModels(List<UslugaEntity> uslugaEntityList);
}

