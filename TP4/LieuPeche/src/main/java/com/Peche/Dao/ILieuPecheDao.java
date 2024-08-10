package com.Peche.Dao;

import com.Generic.GenericDao;
import com.Peche.bo.LieuPeche;

import java.util.List;

public interface ILieuPecheDao extends GenericDao<LieuPeche,Long> {

    List<LieuPeche> getByProf(Double prof);
}
