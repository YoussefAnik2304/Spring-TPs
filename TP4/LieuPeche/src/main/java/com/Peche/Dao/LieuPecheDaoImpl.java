package com.Peche.Dao;

import com.Generic.SpringNativeHibernateGenericDAOImpl;
import com.Peche.bo.LieuPeche;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LieuPecheDaoImpl extends SpringNativeHibernateGenericDAOImpl<LieuPeche,Long> implements ILieuPecheDao {

    @Override
    public LieuPeche create(LieuPeche o) {
        return super.create(o);
    }

    @Override
    public void update(LieuPeche o) {
        super.update(o);
    }

    @Override
    public List<LieuPeche> getAll() {
        return super.getAll();
    }

    @Override
    public LieuPeche findById(Long pId) {
        return super.findById(pId);
    }

    @Override
    public List<LieuPeche> getEntityByColValue(String pColumnName, String pValue) {
        return super.getEntityByColValue(pColumnName, pValue);
    }

    @Override
    public List<LieuPeche> getEntityByColValue(Map<String, String> colValues) {
        return super.getEntityByColValue(colValues);
    }

    @Override
    public void delete(Long pId) {
        super.delete(pId);
    }

    @Override
    public List<LieuPeche> getAllDistinct() {
        return super.getAllDistinct();
    }


    @Override
    public List<LieuPeche> getByProf(Double prof) {
        return super.getEntityByColValue("profondeur", String.valueOf(prof));
    }
}
