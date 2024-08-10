package com.Peche.Service;

import com.Peche.Dao.ILieuPecheDao;
import com.Peche.Dao.LieuPecheDaoImpl;
import com.Peche.bo.LieuPeche;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LieuPecheServiceImpl implements ILieuPecheService {
    @Autowired
    private ILieuPecheDao Dao;
    public LieuPecheServiceImpl() {
    }

    @Override
    public void add_location(LieuPeche lieuPeche) {
        Dao.create(lieuPeche);
    }

    @Override
    public void modify_location(LieuPeche lieuPeche) {
        Dao.update(lieuPeche);
    }

    @Override
    public void delete_location(LieuPeche lieuPeche) {
        Dao.delete(lieuPeche.getId());
    }

    @Override
    public List<LieuPeche> getAll() {
        return Dao.getAll();
    }

    public List<LieuPeche> getByProfondeur(Double prof) {
        return Dao.getByProf(prof);
    }
}
