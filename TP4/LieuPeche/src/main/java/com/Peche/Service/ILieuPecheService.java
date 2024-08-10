package com.Peche.Service;

import com.Peche.Dao.ILieuPecheDao;
import com.Peche.bo.LieuPeche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ILieuPecheService {
    void add_location(LieuPeche lieuPeche);
    void modify_location(LieuPeche lieuPeche);
    void delete_location(LieuPeche lieuPeche);
    List<LieuPeche> getAll();



}
