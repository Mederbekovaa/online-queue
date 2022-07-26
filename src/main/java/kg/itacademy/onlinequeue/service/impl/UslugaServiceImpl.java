package kg.itacademy.onlinequeue.service.impl;

import kg.itacademy.onlinequeue.entity.UslugaEntity;
import kg.itacademy.onlinequeue.mapper.UslugaMapper;

import kg.itacademy.onlinequeue.model.UslugaModel;
import kg.itacademy.onlinequeue.repository.UslugaRepository;
import kg.itacademy.onlinequeue.service.UslugaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UslugaServiceImpl implements UslugaService {

    final UslugaRepository uslugaRepository;
    @Override
    public UslugaEntity create(UslugaModel uslugaModel) {

        UslugaEntity uslugaEntity = UslugaMapper.INSTANCE.toEntity(uslugaModel);
        return uslugaRepository.save(uslugaEntity);
    }

    @Override
    public boolean update(UslugaModel uslugaModel) {

        UslugaEntity uslugaEntity = UslugaMapper.INSTANCE.toEntity(uslugaModel);
        return uslugaRepository.save(uslugaEntity).getId() != null;
    }

    @Override
    public UslugaModel getByUslugaName(String uslugaName) {
        return UslugaMapper.INSTANCE.toModel(uslugaRepository.getByName(uslugaName));
    }

    @Override
    public boolean delete(UslugaModel uslugaModel) {
        try {
            uslugaRepository.delete(uslugaRepository.getByName(uslugaModel.getName()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UslugaModel> getAllUsluga() {
        List<UslugaEntity> uslugaEntityList = uslugaRepository.findAll();
        List<UslugaModel> uslugaModelList = new ArrayList<>();
         return uslugaModelList;
    }
}

