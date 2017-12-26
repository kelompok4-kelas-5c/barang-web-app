/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kelasc.barangwebapp.controller;

import lab.kelasc.barangwebapp.entity.Barang;
import lab.kelasc.barangwebapp.repo.BarangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Syeh,Kukuh,Aji,Desprianto
 */

@Controller
public class AppController {
    @Autowired
    private BarangRepo brgRepo;
    
    @RequestMapping("/home")
    public void index() {}
    
    @RequestMapping("/daftar-barang")
    public void getDaftarBarang(Model model) {
        model.addAttribute("daftarBarang",brgRepo.findAll());
    }
    
    @RequestMapping(value = "/tambah-data" , method = RequestMethod.GET)
    public void getFormTambahData(
    	@ModelAttribute("brg") Barang brg, 
    	BindingResult result ) {}

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.POST)
    public String simpanData(
    	@ModelAttribute("brg") Barang brg, BindingResult result) {

    	System.out.println("ID : " + brg.getId());
    	System.out.println("Jenis : " + brg.getJenis());
    	System.out.println("Nama Barang : " + brg.getNama_barang());
    	brgRepo.save(brg);
    	return "redirect:daftar-barang";
    }
    
    @RequestMapping(value = "/edit-data", method = RequestMethod.GET)
    public void getEditData(@RequestParam(name = "id", required =
    false) String id,
    @ModelAttribute("brg") Barang barang, BindingResult
    binding) {
    Barang brg = brgRepo.findOne(id);
    barang.setId(brg.getId());
    barang.setJenis(brg.getJenis());
    barang.setNama_barang(brg.getNama_barang());
    }
 
 @RequestMapping(value = "/edit-data",
    method = RequestMethod.POST)
    public String saveEditData(
    @ModelAttribute("brg") Barang brg,
    BindingResult binding) {
    brgRepo.save(brg);
    return "redirect:/daftar-barang";
    }
    
 @RequestMapping("/delete")
    public String deleteData(
        @RequestParam(name = "id", required = true) String id) {
        brgRepo.delete(id);
        return "redirect:/daftar-barang";
    }
    
}
