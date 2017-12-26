/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kelasc.barangwebapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Syeh,Kukuh,Aji,Desprianto
 */
@Entity
public class Barang {
    
    @Id @Getter @Setter
    private String id;

    @Column @Getter @Setter
    private String jenis;
    
    @Column @Getter @Setter
    private String nama_barang;

    
    
}

