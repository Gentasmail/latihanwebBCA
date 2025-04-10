package com.bcaf.latihanweb.controller;

import com.bcaf.latihanweb.model.Mahasiswa;
import com.bcaf.latihanweb.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MahasiswaController {

    @Autowired
    private MahasiswaRepository repo;

    @GetMapping("/mahasiswa")
    public String formMahasiswa(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "form";
    }

    @PostMapping("/mahasiswa")
    public String submitMahasiswa(@ModelAttribute Mahasiswa mahasiswa) {
        repo.save(mahasiswa);
        return "redirect:/daftar";
    }

    @GetMapping("/daftar")
    public String daftarMahasiswa(Model model) {
        model.addAttribute("listMahasiswa", repo.findAll());
        return "list";
    }
}
