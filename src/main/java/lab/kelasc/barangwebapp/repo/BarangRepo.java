/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kelasc.barangwebapp.repo;

import lab.kelasc.barangwebapp.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Syeh,Kukuh,Aji,Desprianto
 */
@Repository

public interface BarangRepo

	extends JpaRepository<Barang,String> {}
